package com.james.mapper;

import com.james.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示了这是一个mybatis的mapper类
@Mapper
@Repository
public interface UserMapper {

    //根据用户名和密码来登录
//    User FingByNameAndPwd(String uname,String upwd);
    User FingByNameAndPwd(User user);

    //给用户表添加一条数据
    int addUser(User user);

    //根据用户id获取用户名
    User findByUid(int id);

    //根据用户名获取用户id
    User findByName(String uname);



}
