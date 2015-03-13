package com.itechart.library.webapp.security;

import com.itechart.library.core.user.User;
import com.itechart.library.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("'%s' not found", username));
        }
        return new UserDetailsAdapter(user);
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("qwe123"));
    }
}
