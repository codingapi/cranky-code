package com.codingapi.demo1_4.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private String email;
    private String username;
    private String password;

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }

    public String createToken() {
        return "token:"+username;
    }

    public void verify() {
        if (username == null || username.length() < 4) {
            throw new RuntimeException("username error");
        }
        if (password == null || password.length() < 4) {
            throw new RuntimeException("password error");
        }
        if (email == null || email.length() < 4) {
            throw new RuntimeException("email error");
        }
        if (!email.contains("@")) {
            throw new RuntimeException("email error");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User user) {
            return user.getUsername().equals(username);
        }
        return super.equals(obj);
    }
}
