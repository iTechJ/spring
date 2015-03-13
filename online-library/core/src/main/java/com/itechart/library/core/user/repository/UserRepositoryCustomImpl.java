package com.itechart.library.core.user.repository;

import com.itechart.library.core.user.QUser;
import com.itechart.library.core.user.User;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class UserRepositoryCustomImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {
    private static final QUser USER = QUser.user;

    public UserRepositoryCustomImpl() {
        super(User.class);
    }

    @Override
    public Iterable<User> findByRole(String role) {
        return from(USER)
                .where(USER.roles.contains(role))
                .list(USER);
    }
}
