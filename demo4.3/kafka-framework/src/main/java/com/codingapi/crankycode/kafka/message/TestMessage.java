package com.codingapi.crankycode.kafka.message;

import com.codingapi.crankycode.kafka.event.KafkaEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class TestMessage extends KafkaEvent {

    private String msg;

    public TestMessage() {
        super(MessageConstants.TOPIC_TEST);
    }

}
