package com.james.service.impl;

import com.james.pojo.User;
import com.james.service.UserService;
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
    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public String findByUid(int id) {
        return null;
    }

    @Override
    public User login(String uname, String upwd) {
        User user = new User();
        user.setUname(uname);
        user.setUpwd(upwd);

        return null;
    }
}
