package com.jokertian.validation.controller;

import com.jokertian.validation.bean.Student;
import com.jokertian.validation.bean.Teacher;
import com.jokertian.validation.bean.ValidList;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author 田朋朋
 * @date 2022/5/15 18:40
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @PostMapping("/json")
    public String json(@Validated @RequestBody Teacher teacher) {
        return teacher.toString();
    }

    @PostMapping("/json1")
    public String json1(@RequestBody List<@Min(value = 5) Integer> ages) {
        return ages.toString();
    }

    @PostMapping("/json2")
    public String json2(@RequestBody List<@Valid Student> students) {
        return students.toString();
    }

    @PostMapping("/json3")
    public String json3(@Valid @RequestBody ValidList<Student> students) {
        return students.toString();
    }
}
