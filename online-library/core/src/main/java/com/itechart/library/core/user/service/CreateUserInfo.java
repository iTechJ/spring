package com.itechart.library.core.user.service;

import com.itechart.library.core.user.User;

public class CreateUserInfo extends UserInfo {
    private String login;

    public CreateUserInfo() {
    }

    public CreateUserInfo(String login, String password, String lastName, String firstName) {
        super(password, firstName, lastName);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    void applyValues(User user) {
        super.applyValues(user);

        user.setPassword(getPassword());
        user.setLogin(login);
    }
}
