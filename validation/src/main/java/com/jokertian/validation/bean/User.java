package com.jokertian.validation.bean;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;
import javax.validation.groups.Default;

/**
 * @author 田朋朋
 * @date 2022/8/7 14:47
 */
public class User {

    @NotEmpty(message = "firstName may be empty")
    private String firstName;

    @NotEmpty(message = "middleName may be empty", groups = Default.class)
    private String middleName;

    @NotEmpty(message = "lastName may be empty", groups = GroupA.class)
    private String lastName;

    @NotEmpty(message = "country may be empty", groups = GroupB.class)
    private String country;


    public interface GroupA {
    }

    public interface GroupB {
    }

    /**
     * 组序列
     */
    @GroupSequence({Default.class, GroupA.class, GroupB.class})
    public interface Group {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}