package com.itechart.library.core.user;


import com.itechart.library.core.entity.Entity;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.Set;

@javax.persistence.Entity
@Table(name = "USERS")
public class User extends Entity {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Status status;
    private Set<String> roles;

    @Column
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @ElementCollection(targetClass = String.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "USER_ROLES", joinColumns = {@JoinColumn(name = "USER_ID")})
    @Column(name = "ROLE")
    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    @Transient
    public boolean isActive() {
        return status == Status.ACTIVE;
    }

    public static enum Status {
        ACTIVE, BLOCKED;
    }
}
