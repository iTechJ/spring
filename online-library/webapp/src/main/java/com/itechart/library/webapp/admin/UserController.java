package com.itechart.library.webapp.admin;

import com.itechart.library.core.user.User;
import com.itechart.library.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findUser() {
        ModelAndView modelAndView = new ModelAndView("admin-users");
        Iterable<User> users = userService.findAll();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value = "{userId}/change-status", method = RequestMethod.GET)
    public String changeStatus(@PathVariable(value = "userId") long userId, @RequestParam(value = "current") User.Status currentStatus) {
        if (currentStatus == User.Status.ACTIVE) {
            userService.blockUser(userId);
        } else {
            userService.activateUser(userId);
        }
        return "redirect:/admin/users";

    }
}
