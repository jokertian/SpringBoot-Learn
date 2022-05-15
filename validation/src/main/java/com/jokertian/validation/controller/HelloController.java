package com.jokertian.validation.controller;

import com.jokertian.validation.bean.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

/**
 * @author 田朋朋
 * @date 2022/5/15 17:15
 */
@RestController
@RequestMapping("/student")
@Validated
public class HelloController {

    @PostMapping("/form")
    public String form(@Validated Student student) {
        return student.toString();
    }

    @PostMapping("/json")
    public String json(@Validated @RequestBody Student student) {
        return student.toString();
    }

    @PostMapping("/raw")
    public String raw(@RequestParam("age") @Min(value = 18, message = "年龄大于18") Integer age) {
        return age.toString();
    }
}
