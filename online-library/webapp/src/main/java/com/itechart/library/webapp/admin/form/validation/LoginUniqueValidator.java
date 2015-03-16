package com.itechart.library.webapp.admin.form.validation;

import com.itechart.library.core.user.service.UserService;
import com.itechart.library.webapp.admin.form.validation.annotation.LoginUnique;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginUniqueValidator implements ConstraintValidator<LoginUnique, String> {
    @Autowired
    private UserService userService;

    @Override
    public void initialize(LoginUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isEmpty(value) || userService.findByLogin(value) == null;
    }
}
