package com.codingapi.demo1_4.event;

import com.codingapi.springboot.framework.event.IEvent;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserRegisterEvent implements IEvent {

    private final String username;
    private final long timestamp;

    public UserRegisterEvent(String username) {
        this.username = username;
        this.timestamp = System.currentTimeMillis();
    }
}
