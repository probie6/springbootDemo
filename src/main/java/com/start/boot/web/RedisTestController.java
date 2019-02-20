package com.start.boot.web;

import com.start.boot.entity.User;
import com.start.boot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    RedisConnectionFactory factory;

    @Autowired
    RedisTemplate<String,Object> template;

    @Autowired
    RedisService redisService;


    @RequestMapping("/connect")
    public void redisConnect() {
        RedisConnection connection = factory.getConnection();
        connection.set("hello".getBytes(),"world".getBytes());
        System.out.println(new String (connection.get("hello".getBytes())));
    }

    @RequestMapping("/template")
    public void testRedisTemplate() {
        template.opsForValue().set("hello","world");
        System.out.println(template.opsForValue().get("hello"));

    }

    @RequestMapping("/getUserInfo")
    public void getUserInfo(String id) {
        User user = redisService.getUserInfo(id);
        System.out.println(user.toString());
    }

    @RequestMapping("/clearRedis")
    public void clearRedis(String id) {
       redisService.clearRedis(id);
    }

}
