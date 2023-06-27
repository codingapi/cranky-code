package com.example.oa.message;

import com.codingapi.crankycode.kafka.event.BaseEvent;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TestMsg extends BaseEvent {

    private String msg;

    public TestMsg(String msg) {
        super("test");
        this.msg = msg;
    }

}
