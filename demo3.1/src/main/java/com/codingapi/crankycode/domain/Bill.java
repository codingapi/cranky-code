package com.codingapi.crankycode.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bill {

    private String billNo;
    private int money;
    private long timestamp;
    private Order order;
    private User user;


    public Bill(Order order, User user) {
        this.billNo = String.format("NO%s",System.currentTimeMillis());
        this.order = order;
        this.user = user;
        this.timestamp = System.currentTimeMillis();
    }
}
