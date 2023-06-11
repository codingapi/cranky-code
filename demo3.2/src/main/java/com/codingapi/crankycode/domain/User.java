package com.codingapi.crankycode.domain;

import lombok.Getter;

public class User {

    @Getter
    private String username;

    @Getter
    private String password;

    private final static String DEFAULT_PASSWORD = "123456";

    public User(String username) {
        this.username = username;
        this.password = DEFAULT_PASSWORD;
    }

    public void resetPassword(String password){
        verifyPassword(password);
        this.password = password;
    }

    public void changePassword(String oldPassword,String newPassword){
        verifyPassword(newPassword);
        if(!match(oldPassword)){
            throw new IllegalArgumentException("old password is not match");
        }
        this.password = newPassword;
    }

    public boolean match(String password){
        return this.password.equals(password);
    }

    private void verifyPassword(String password){
        if(password == null || password.length() < 6){
            throw new IllegalArgumentException("password is too short");
        }
    }
}
