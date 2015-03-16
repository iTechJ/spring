package com.itechart.library.webapp.admin.form;

import com.itechart.library.core.user.User;
import com.itechart.library.core.user.service.CreateUserInfo;
import com.itechart.library.core.user.service.UserInfo;
import com.itechart.library.webapp.admin.form.validation.Create;
import com.itechart.library.webapp.admin.form.validation.annotation.LoginUnique;
import com.itechart.library.webapp.validation.annotation.EqualProperties;
import com.itechart.library.webapp.validation.annotation.SizeIfNotEmpty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.groups.Default;

@EqualProperties(properties = {"password", "confirmPassword"}, message = "{user.form.passwords.not.equal}")
public class UserForm {
    private Long id;
    @NotEmpty(groups = Create.class, message = "{user.form.empty.login}")
    @LoginUnique(groups = Create.class, message = "{user.form.login.not.unique}")
    private String login;

    @NotEmpty(groups = Create.class, message = "{user.form.empty.password}")
    @SizeIfNotEmpty(min = 6, message = "{user.form.password.min.length}")
    private String password;

    private String confirmPassword;

    @NotEmpty(groups = Default.class, message = "{user.form.empty.lastName}")
    private String lastName;

    @NotEmpty(groups = Default.class, message = "{user.form.empty.firstName}")
    private String firstName;

    public UserForm() {
    }

    public UserForm(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.lastName = user.getLastName();
        this.firstName = user.getFirstName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public CreateUserInfo toCreateUserInfo() {
        return new CreateUserInfo(login, password, lastName, firstName);
    }

    public UserInfo toUserInfo() {
        return new UserInfo(password, lastName, firstName);
    }
}
