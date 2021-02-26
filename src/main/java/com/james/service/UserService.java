package com.james.service;

import com.james.pojo.User;

public interface UserService {

    //登录
    User login(String uname, String upwd);

    //注册
    boolean register(User user);

    //根据用户id获取用户名
    String findByUid(int id);

    //根据用户名获取用户id
    int findByName(String uname);

}
