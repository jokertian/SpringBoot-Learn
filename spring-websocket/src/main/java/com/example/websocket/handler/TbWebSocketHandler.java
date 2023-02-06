package com.example.websocket.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@Service
@Slf4j
public class TbWebSocketHandler extends TextWebSocketHandler {

    private final static Map<String, WebSocketSession> userMap = new ConcurrentHashMap<String, WebSocketSession>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        String userId = this.getUserId(session);
        if (Objects.nonNull(userId)) {
            userMap.put(userId, session);
            session.sendMessage(new TextMessage("建立服务端连接成功！"));
        }
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
        String msg = message.toString();
        String userId = this.getUserId(session);
        System.err.println("该" + userId + "用户发送的消息是：" + msg);
        message = new TextMessage("服务端已经接收到消息，msg=" + msg);
        session.sendMessage(message);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        super.handlePongMessage(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
        WebSocketMessage<String> message = new TextMessage("异常信息："
                + exception.getMessage());
        session.sendMessage(message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        String userId = this.getUserId(session);
        if (Objects.nonNull(userId)) {
            userMap.remove(userId);
            System.err.println("该" + userId + "用户已成功关闭");
        } else {
            System.err.println("关闭时，获取用户id为空");
        }
    }

    /**
     * sendMessageToUser:发给指定用户
     *
     */
    public void sendMessageToUser(String userId, String contents) {
        WebSocketSession session = userMap.get(userId);
        if (session != null && session.isOpen()) {
            try {
                TextMessage message = new TextMessage(contents);
                session.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * sendMessageToAllUsers:发给所有的用户
     *
     */
    public void sendMessageToAllUsers(String contents) {
        Set<String> userIds = userMap.keySet();
        for (String userId : userIds) {
            this.sendMessageToUser(userId, contents);
        }
    }


    private String getUserId(WebSocketSession session) {
        try {
            String userId = (String) session.getAttributes().get("currentUser");
            return userId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}