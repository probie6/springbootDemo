package com.start.boot.service.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.start.boot.entity.User;
import com.start.boot.service.TokenService;
import jdk.nashorn.internal.parser.Token;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    /**
     * 获取token
     * @param user
     * @return
     */
    @Override
    public String getToken(User user) {
        String token;
        token = JWT.create().withAudience(user.getId()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;














    }
}
