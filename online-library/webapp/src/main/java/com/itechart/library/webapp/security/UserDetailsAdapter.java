package com.itechart.library.webapp.security;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Set;

public class UserDetailsAdapter extends User {
    private com.itechart.library.core.user.User user;

    public UserDetailsAdapter(com.itechart.library.core.user.User user) {
        super(user.getLogin(), user.getPassword(), user.isActive(), true, true, user.isActive(), buildGrantedAuthorities(user.getRoles()));
        this.user = user;

    }

    private static Collection<? extends GrantedAuthority> buildGrantedAuthorities(Set<String> roles) {
        return Sets.newHashSet(Iterables.transform(roles, new Function<String, GrantedAuthority>() {
            @Nullable
            @Override
            public GrantedAuthority apply(String role) {
                return new SimpleGrantedAuthority(role);
            }
        }));
    }

    public String getFullName() {
        return Joiner.on(" ").join(user.getLastName(), user.getFirstName());
    }


}
