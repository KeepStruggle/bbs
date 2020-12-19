package com.james.mapper;

import com.james.pojo.User;

import java.util.List;

public interface UserMapper {

    //根据用户名和密码来登录
    User FingByNameAndPwd(String uname,String upwd);

    //给用户表添加一条数据
    int add(User user);

    //根据用户id获取用户名
    String findByUid(int uid);

}
