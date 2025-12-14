package com.nk.models;

import com.nk.models.enums.UserRole;
import com.nk.models.enums.UserStatus;

public class User {

    private static long userCount = 0;
    private final long id;
    private String password;
    private UserRole role;
    private UserStatus status;

    public User(String password, UserRole role, UserStatus status) {
        this.id = ++userCount;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}