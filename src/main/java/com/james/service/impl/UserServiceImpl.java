package com.james.service.impl;

import com.james.mapper.UserMapper;
import com.james.pojo.User;
import com.james.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.8
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author James
 * @date 2020/12/16 9:26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public String findByUid(int id) {
        User user = userMapper.findByUid(id);
        return user.getUname();
    }

    @Override
    public int findByName(String uname) {
        User user = userMapper.findByName(uname);
        return user.getUid();
    }

    @Override
    public User login(String uname, String upwd) {
        User user = new User();
        user.setUname(uname);
        user.setUpwd(upwd);

        User user1 = userMapper.FingByNameAndPwd(user);

        return user1;
    }
}
