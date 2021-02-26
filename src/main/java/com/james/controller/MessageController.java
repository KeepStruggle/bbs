package com.james.controller;

import com.james.pojo.Message;
import com.james.pojo.User;
import com.james.service.MessageService;
import com.james.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.8
 * @ClassName MessageController
 * @Description TODO
 * @Author James
 * @date 2020/12/16 11:23
 */
@Controller
public class MessageController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @GetMapping("/message/list")
    @ResponseBody
    public List<Message> showMessageList(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Message> messageList = messageService.showAllByUid(user.getUid());
        System.out.println(messageList);
        return messageList;
    }

    @GetMapping("/message/sendNewMsg")
    public String sendNewMsg(Model model){
        return "newMsg";
    }

    @PostMapping("/message/doSendNewMsg")
    public String doSendNewMsg(@RequestParam String toUser, @RequestParam String title, @RequestParam String content,HttpSession session, Model model) throws IOException {

        //增加一条记录到message表中
        //1.找到发件人id，收件人的id
        User user = (User) session.getAttribute("user");
        //2.封装成为Message对象
        Message message = new Message();
        message.setFid(user.getUid());
        message.setTid(userService.findByName(toUser));
        message.setTitle(title);
        message.setContent(content);
        //3.调用dao，插入数据
        System.out.println(message);
        if(messageService.add(message)){
            session.setAttribute("msg","发送成功");
            return "redirect:/main.html";
        }else {
            session.setAttribute("msg", "发送失败");
            return "newMsg";
        }
    }

    @GetMapping("/message/reply/{id}")
    public String reply(@PathVariable int id, Model model){
        System.out.println(id);
        Message message = messageService.findById(id);
//        Message message = new Message(1, 1, 2, "James", "dfasd", 1, "2020/12/16");
        System.out.println(message);
        model.addAttribute("message", message);
        //查找消息的发件人姓名
        String fname = userService.findByUid(message.getFid());
        model.addAttribute("fname", fname);
        return "newMsg";
    }


    @PostMapping("/message/delete")
    @ResponseBody
    public String deleteMsg(@RequestParam("id") int id){
        System.out.println(id);
        messageService.del(id);
        return "true";
    }

    @GetMapping("/message/read/{id}")
    public String readMsg(@PathVariable int id, Model model){
        System.out.println(id);

        //消息已读，修改数据库消息状态为已读
        messageService.update(id);

        Message message = messageService.findById(id);
        System.out.println(message);

         //查找消息的发件人
        String fname = userService.findByUid(message.getFid());
        System.out.println(fname);
        model.addAttribute("fname", fname);
        model.addAttribute("message", message);
        return "readMsg";
    }
}
