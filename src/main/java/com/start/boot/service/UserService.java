package com.start.boot.service;

import com.start.boot.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findUserById(String id);

}
