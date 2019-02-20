package com.start.boot.service.Impl;

import com.start.boot.entity.User;
import com.start.boot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(String id) {
        if(id.equals("zhangsan")) {
            return new User(id,"张三","123456");
        }

        return null;
    }
}
