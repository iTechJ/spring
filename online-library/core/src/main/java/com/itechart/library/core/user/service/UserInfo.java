package com.itechart.library.core.user.service;

import com.itechart.library.core.user.User;
import org.apache.commons.lang3.StringUtils;

public class UserInfo {
    private String password;
    private String firstName;
    private String lastName;

    public UserInfo() {
    }

    public UserInfo(String password, String lastName, String firstName) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    void applyValues(User user) {
        if (!StringUtils.isBlank(password)) {
            user.setPassword(password);
        }
        user.setLastName(lastName);
        user.setFirstName(firstName);
    }
}
