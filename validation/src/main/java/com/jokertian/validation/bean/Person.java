package com.jokertian.validation.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author 田朋朋
 * @date 2022/5/15 22:00
 */
public class Person {
    public interface Save {
    }

    public interface Update {
    }

    @NotBlank(message = "名字不能为空", groups = {Save.class, Update.class})
    private String name;
    @Min(value = 18, message = "年龄必须大于18", groups = {Update.class})
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
