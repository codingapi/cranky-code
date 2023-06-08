package com.codingapi.crankycode.event;

import com.codingapi.crankycode.domain.Order;
import com.codingapi.springboot.framework.event.IEvent;
import lombok.Getter;

@Getter
public class OrderPayEvent implements IEvent {

    private Order order;
    private long timestamp;

    public OrderPayEvent(Order order) {
        this.order = order;
        this.timestamp = System.currentTimeMillis();
    }

}
