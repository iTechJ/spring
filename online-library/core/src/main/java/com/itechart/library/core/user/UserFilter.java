package com.itechart.library.core.user;

import java.util.Set;

public class UserFilter {
    private String login;
    private String firstName;
    private String lastName;
    private User.Status status;

    public UserFilter() {
    }

    public UserFilter(String login, String firstName, String lastName, User.Status status) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public User.Status getStatus() {
        return status;
    }

    public void setStatus(User.Status status) {
        this.status = status;
    }
}
