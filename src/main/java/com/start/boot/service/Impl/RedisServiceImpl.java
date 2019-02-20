package com.start.boot.service.Impl;

import com.start.boot.entity.User;
import com.start.boot.service.RedisService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
    @Override
    @Cacheable(value = "user",key = "#id")
    public User  getUserInfo(String id) {

        System.out.println("第一次从DB中读取");
        User user = new User("0000","wf","123456");
        return user;
    }

    @Override
    @CacheEvict(value = "user",key = "#id")
    public void clearRedis(String id) {

        System.out.println("清除user缓存");

    }
}
