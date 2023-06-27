package com.codingapi.crankycode.kafka.event;


import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

@AllArgsConstructor
public class EventRegister {

    private final KafkaTemplate<String,BaseEvent> template;

    public void init(){
        EventPusher.getInstance().init(template);
    }
}