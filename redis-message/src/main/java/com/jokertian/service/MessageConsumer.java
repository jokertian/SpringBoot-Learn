package com.jokertian.service;

import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.Topic;

/**
 * @author 田朋朋
 * @date 2022/3/24 15:54
 */
public interface MessageConsumer {
    Topic getTopic();
    MessageListener getMessageListener();
}
