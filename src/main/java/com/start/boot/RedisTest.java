package com.start.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;

public class RedisTest {
    @Autowired
    RedisConnectionFactory factory;

    @Test
    public void testRedis() {
        RedisConnection connection = factory.getConnection();
        connection.set("hello".getBytes(),"world".getBytes());
        System.out.println(connection.get("hello".getBytes()));
    }
}
