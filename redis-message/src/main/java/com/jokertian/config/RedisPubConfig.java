package com.jokertian.config;

import com.jokertian.service.MessageConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.util.List;

/**
 * @author 田朋朋
 * @date 2022/3/24 16:07
 */
@Configuration
public class RedisPubConfig {

    @Autowired
    private List<MessageConsumer> messageConsumers;

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory factory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        for (MessageConsumer consumer : messageConsumers) {
            container.addMessageListener(consumer.getMessageListener(), consumer.getTopic());
        }
        return container;
    }
}
