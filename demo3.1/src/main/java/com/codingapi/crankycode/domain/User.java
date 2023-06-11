package com.codingapi.crankycode.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private String username;
    private String password;

    public User(String username) {
        this.username = username;
    }
}
