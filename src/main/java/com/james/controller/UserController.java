package com.james.controller;

import com.james.mapper.UserMapper;
import com.james.pojo.User;
import com.james.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @version 1.8
 * @ClassName HelloController
 * @Description TODO
 * @Author James
 * @date 2020/12/11 0:15
 */
@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam("uname") String uname, @RequestParam("upwd") String upwd, Model model, HttpSession session){
        User user = userService.login(uname, upwd);
//        User user = new User(1,"郑弘湛","123456","1927666233@qq.com");
        if(user != null){
            session.setAttribute("user", user);
            //使用重定向到main.html, 这是一个请求，定义在MyMvcConfig里面
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "账号密码错误，请重新登录！");
            return "index";
        }
    }

    @GetMapping("/exit")
    public String exit(HttpSession session){
        session.removeAttribute("user");
        return "index";
    }




//    @GetMapping("/main")
//    public String main(){
//        return "main";
//    }
//    @GetMapping("/newMsg")
//    public String newMsg(){
//        return "newMsg";
//    }
//    @GetMapping("/readMsg")
//    public String readMsg(){
//        return "readMsg";
//    }
//    @GetMapping("/register")
//    public String register(){
//        return "register";
//    }
//
//    @GetMapping("/test")
//    @ResponseBody
//    public String test(){
//        String name = "zhangsan";
//        return name;
//    }
//
//    @GetMapping("/testMybatis")
//    @ResponseBody
//    public Object testMybatis(){
//        User user = userMapper.findByUid(1);
//        return user;
//    }

}

/*
* 理想结果：
* 1、当消息查看过后，图标变为已读 (已完成)
* 2、消息列表优先按未读到已读，未读中按时间排列，已读中也按时间排列。(已完成)
* 3、消息太多，做分页处理（待完成）
* 4、分为已读消息列表、未读消息列表
* */