package com.itechart.library.core.user.repository;

import com.itechart.library.core.user.User;
import com.itechart.library.core.user.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserRepositoryCustom {
    Iterable<User> findByRole(String role);
}
