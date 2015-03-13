package com.itechart.library.core.user.service;

import com.itechart.library.core.user.User;
import com.itechart.library.core.user.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User findByLogin(String login);

    Iterable<User> findAll();

    Page<User> findAll(Pageable pageable);

    Page<User> find(UserFilter filter, Pageable pageable);

    Iterable<User> findByRole(String role);

    void blockUser(long userId);

    void activateUser(long userId);
}
