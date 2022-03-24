package com.jokertian.service.impl;

import com.jokertian.service.MessageConsumer;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Component;

/**
 * @author 田朋朋
 * @date 2022/3/24 16:04
 */
@Component
public class LikeWomanMessageConsumer implements MessageConsumer {
    @Override
    public Topic getTopic() {
        return ChannelTopic.of("like-woman");
    }

    @Override
    public MessageListener getMessageListener() {
        return new LikeWomanMessageListener();
    }

    static class LikeWomanMessageListener implements MessageListener{

        @Override
        public void onMessage(Message message, byte[] pattern) {
            System.out.println("body:" + new String(message.getBody()));
            System.out.println("channel:" + new String(message.getChannel()));
            System.out.println("pattern:" + new String(pattern));
        }
    }
}
