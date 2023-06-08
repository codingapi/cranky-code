package com.codingapi.crankycode.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {

    private long id;
    private String name;
    private Merchant merchant;

    public Product(String name, Merchant merchant) {
        this.name = name;
        this.merchant = merchant;
        this.id = System.currentTimeMillis();
    }
}
