package com.codingapi.crankycode.kafka.event;


import lombok.Getter;

import java.io.Serializable;
import java.util.Calendar;

public class BaseEvent implements Serializable {

    @Getter
    private final String topic;

    @Getter
    private final long ts;

    public BaseEvent(String topic) {
        this.topic = topic;
        this.ts = Calendar.getInstance().getTimeInMillis();
    }

}
