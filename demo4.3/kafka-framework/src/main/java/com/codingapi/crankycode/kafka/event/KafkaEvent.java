package com.codingapi.crankycode.kafka.event;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Calendar;

@Getter
@Setter
public class KafkaEvent implements Serializable {

    private final String topic;

    private final long ts;

    public KafkaEvent(String topic) {
        this.topic = topic;
        this.ts = Calendar.getInstance().getTimeInMillis();
    }

}
