package com.codingapi.crankycode.kafka.event;


import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

@AllArgsConstructor
public class KafkaRegister {

    private final KafkaTemplate<String, KafkaEvent> template;

    public void init(){
        KafkaPusher.getInstance().init(template);
    }
}