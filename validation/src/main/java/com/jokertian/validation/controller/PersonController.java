package com.jokertian.validation.controller;

import com.jokertian.validation.bean.Person;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 田朋朋
 * @date 2022/5/15 22:05
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping("/save")
    public String save(@Validated(Person.Save.class) @RequestBody Person person) {
        return person.toString();
    }

    @PostMapping("/update")
    public String update(@Validated(Person.Update.class) @RequestBody Person person) {
        return person.toString();
    }
}
