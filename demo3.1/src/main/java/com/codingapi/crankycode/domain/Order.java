package com.codingapi.crankycode.domain;

import com.codingapi.crankycode.event.OrderPayEvent;
import com.codingapi.springboot.framework.event.EventPusher;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Order {

    private final User user;

    private final long createTime;

    private final List<Product> products;

    private State state;


    public enum State{
        CREATE,PAYED,
    }

    public Order(User user, List<Product> products) {
        this.user = user;
        this.products = products;
        this.createTime = System.currentTimeMillis();

        this.verify();
    }


    private void verify(){
        if(user==null){
            throw new RuntimeException("user must not null.");
        }
        if(products==null||products.size()==0){
            throw new RuntimeException("products must not null.");
        }
    }


    public void pay(){
        state = State.PAYED;
        EventPusher.push(new OrderPayEvent(this));
    }

}
