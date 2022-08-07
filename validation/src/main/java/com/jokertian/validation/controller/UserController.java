package com.jokertian.validation.controller;

import com.jokertian.validation.bean.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 田朋朋
 * @date 2022/8/7 14:52
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/json")
    public String userInfo(@Validated({User.Group.class}) @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            for (FieldError fieldError : result.getFieldErrors()) {
                System.out.println(fieldError.getDefaultMessage());
            }
            return "";
        }
        return user.toString();
    }
}