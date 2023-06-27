package com.example.oa.model.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class User {

    @Getter
    private final String username;

    public User(String username) {
        this.username = username;
    }


}
