package com.jokertian.rediscahce.service;

import com.jokertian.rediscahce.bean.User;

/**
 * @author joker-tian
 * @date 2022/2/14 13:52
 */
public interface UserService {
    /**
     * 把用户信息添加到缓存
     * @param user 需要添加到缓存的用户信息
     */
    void addUser(User user);

    /**
     * 根据用户ID从缓存查询用户信息
     * @param id 用户ID
     * @return 匹配ID的用户信息
     */
    User selectUserById(Long id);

    /**
     * 更新用户信息
     * @param user 新的用户信息
     * @return 返回旧的用户信息
     */
    User updateUser(User user);

    /**
     * 根据用户ID删除用户信息
     * @param id 用户ID
     */
    void deleteUserById(Long id);
}
