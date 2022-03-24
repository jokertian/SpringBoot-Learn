package com.jokertian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 田朋朋
 * @date 2022/3/24 15:49
 */
@RestController
public class MessageController {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @RequestMapping("/publishMessage")
    public String publishMessage(String channel, String message) {
        redisTemplate.convertAndSend(channel, message);
        return channel + "->" + message;
    }
}
