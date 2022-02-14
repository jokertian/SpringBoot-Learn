package com.jokertian.rediscahce.service.impl;

import com.jokertian.rediscahce.bean.User;
import com.jokertian.rediscahce.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author joker-tian
 * @date 2022/2/14 13:54
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {
    Map<Long, User> map = new ConcurrentHashMap<>(64);

    @Override
    public void addUser(User user) {
        map.put(user.getId(), user);
    }

    @Override
    @Cacheable(key = "#id")
    public User selectUserById(Long id) {
        if (!map.containsKey(id)) {
            return null;
        }
        return map.get(id);
    }

    @Override
    @CachePut(key = "#user.id")
    public User updateUser(User user) {
        if (!map.containsKey(user.getId())) {
            throw new RuntimeException("不存在该用户");
        }
        User newUser = map.get(user.getId());
        newUser.setPassword(user.getPassword());
        map.put(newUser.getId(), newUser);
        return newUser;
    }

    @Override
    @CacheEvict(key = "#id")
    public void deleteUserById(Long id) {
        map.remove(id);
    }
}
