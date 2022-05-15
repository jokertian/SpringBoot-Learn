package com.jokertian.validation.bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author 田朋朋
 * @date 2022/5/15 17:11
 */
public class Student {
    @NotBlank(message = "名字不能为空")
    private String name;
    @Min(value = 18, message = "年龄必须大于18")
    private Integer age;
    @Digits(integer = 4, fraction = 2, message = "钱整数位4，小数位2")
    private BigDecimal money;
    @FutureDate
    private LocalDateTime birthTime = LocalDateTime.now().plusDays(1);

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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public LocalDateTime getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(LocalDateTime birthTime) {
        this.birthTime = birthTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", birthTime=" + birthTime +
                '}';
    }
}
