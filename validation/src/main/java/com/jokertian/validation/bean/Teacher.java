package com.jokertian.validation.bean;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 田朋朋
 * @date 2022/5/15 18:40
 */
public class Teacher {
    @NotBlank(message = "名字不能为空")
    private String name;
    @Valid
    @NotNull
    private Student student;
    @NotNull
    private List<@Min(value = 5) Integer> ageList;
    @NotNull
    private List<@Valid @NotNull Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Integer> getAgeList() {
        return ageList;
    }

    public void setAgeList(List<Integer> ageList) {
        this.ageList = ageList;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", student=" + student +
                ", ageList=" + ageList +
                ", students=" + students +
                '}';
    }
}
