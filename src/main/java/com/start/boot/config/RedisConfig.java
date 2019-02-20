package com.start.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * auth wangfei
 * data 2018-11-3
 * msg redis配置类
 */
@Configuration
public class RedisConfig {

    /**
     * 指定redisip以及端口，如果不配置此方法，则会默认读取本地启动的redis服务。
     * 如果需要使用其他服务器上运行的redis，则需要配置此方法表明redis服务位置
     * @return
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPort(6379);
        factory.setHostName("localhost");
        return factory;
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        return template;
    }
}
