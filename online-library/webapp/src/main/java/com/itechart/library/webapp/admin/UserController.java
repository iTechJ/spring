package com.itechart.library.webapp.admin;

import com.itechart.library.core.user.User;
import com.itechart.library.core.user.service.CreateUserInfo;
import com.itechart.library.core.user.service.UserInfo;
import com.itechart.library.core.user.service.UserService;
import com.itechart.library.webapp.admin.form.UserForm;
import com.itechart.library.webapp.admin.form.validation.Create;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.groups.Default;

@Controller
@RequestMapping(value = "/admin/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private String hashPasswordIfNeed(String rawPassword) {
        return StringUtils.isBlank(rawPassword) ? null : passwordEncoder.encode(rawPassword);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findUser() {
        ModelAndView modelAndView = new ModelAndView("admin-users");
        Iterable<User> users = userService.findAll();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value = "/{userId}/change-status", method = RequestMethod.GET)
    public String changeStatus(@PathVariable(value = "userId") long userId, @RequestParam(value = "current") User.Status currentStatus) {
        if (currentStatus == User.Status.ACTIVE) {
            userService.blockUser(userId);
        } else {
            userService.activateUser(userId);
        }
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/creating", method = RequestMethod.GET)
    public ModelAndView creating() {
        ModelAndView modelAndView = new ModelAndView("admin-user");
        modelAndView.addObject("userForm", new UserForm());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Validated(value = {Create.class, Default.class}) UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin-user";
        } else {
            CreateUserInfo userInfo = userForm.toCreateUserInfo();
            userInfo.setPassword(hashPasswordIfNeed(userForm.getPassword()));
            userService.create(userInfo);
        }
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "{userId}/editing", method = RequestMethod.GET)
    public ModelAndView editing(@PathVariable(value = "userId") long userId) {
        ModelAndView modelAndView = new ModelAndView("admin-user");
        modelAndView.addObject("userForm", new UserForm(userService.find(userId)));
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String save(@ModelAttribute(value = "userForm") @Validated UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin-user";
        } else {
            UserInfo userInfo = userForm.toUserInfo();
            userInfo.setPassword(hashPasswordIfNeed(userForm.getPassword()));
            userService.update(userForm.getId(), userInfo);
        }
        return "redirect:/admin/users";
    }
}
