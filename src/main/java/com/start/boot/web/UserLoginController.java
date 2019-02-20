package com.start.boot.web;


import com.start.boot.annotation.UserLoginToken;
import com.start.boot.entity.User;
import com.start.boot.service.TokenService;
import com.start.boot.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserLoginController {

    private static Logger log = Logger.getLogger(UserLoginController.class);

    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @RequestMapping("/login")
    @ResponseBody
    public Map hello(String userId,String passWord) {
        Map map = new HashMap<>();
        User user = userService.findUserById(userId);
        if(user == null) {
            throw new RuntimeException("用户不存在!");
        }
        if(!user.getPassword().equals(passWord)) {
            throw new RuntimeException("密码错误!");
        }
        String token = tokenService.getToken(user);
        map.put("token",token);
        map.put("user",user);
        log.debug("debug登录成功");
        log.error("error登录成功");
        log.info("info登录成功");
        return map;

    }

    @UserLoginToken
    @RequestMapping("/getMessage")
    @ResponseBody
    public Map getMessage() {
        Map map = new HashMap();
        map.put("message","通过验证");
        return map;
    }


}
