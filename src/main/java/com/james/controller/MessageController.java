package com.james.controller;

import com.james.pojo.Message;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/message/list")
    @ResponseBody
    public List<Message> showMessageList(){
        List<Message> messageList = new ArrayList<>();
        Message message1 = new Message(1, 1, 2, "James", "dfasd", 1, "2020/12/16");
        Message message2 = new Message(2, 1, 2, "zhangsan", "dfasd", 1, "2020/12/16");
        Message message3 = new Message(3, 1, 2, "lisi", "dfasd", 1, "2020/12/16");
        messageList.add(message1);
        messageList.add(message2);
        messageList.add(message3);
        return messageList;
    }

    @GetMapping("/message/sendNewMsg")
    public String sendNewMsg(Model model){
        return "newMsg";
    }

    @GetMapping("/message/reply/{id}")
    public String reply(@PathVariable int id, Model model){
        System.out.println(id);
        Message message = new Message(1, 1, 2, "James", "dfasd", 1, "2020/12/16");
        model.addAttribute("message", message);
        //查找消息的发件人姓名
        model.addAttribute("fname", "wangwu");
        return "newMsg";
    }


    @PostMapping("/message/delete")
    @ResponseBody
    public String deleteMsg(@RequestParam("id") int id){
        System.out.println(id);
        return "true";
    }

    @GetMapping("/message/read/{id}")
    public String readMsg(@PathVariable int id, Model model){
        System.out.println(id);
        Message message = new Message(1, 1, 2, "James", "dfasd", 1, "2020/12/16");
        //查找消息的发件人
        model.addAttribute("fname", "二狗");
        model.addAttribute("message", message);
        return "readMsg";
    }
}
