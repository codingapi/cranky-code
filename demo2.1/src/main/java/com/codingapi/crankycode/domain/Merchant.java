package com.codingapi.crankycode.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Merchant {

    private long id;
    private String name;

    public Merchant(String name) {
        this.name = name;
        this.id = System.currentTimeMillis();
    }
}
