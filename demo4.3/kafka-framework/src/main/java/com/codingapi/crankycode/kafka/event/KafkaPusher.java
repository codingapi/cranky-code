package com.codingapi.crankycode.kafka.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
public class KafkaPusher {

    private final static KafkaPusher instance = new KafkaPusher();

    public static KafkaPusher getInstance() {
        return instance;
    }

    public void pushEvent(KafkaEvent event){
        if(template!=null) {
            template.send(event.getTopic(), event);
        }
    }

    private KafkaTemplate<String, KafkaEvent> template;

    void init(KafkaTemplate<String, KafkaEvent> template){
        this.template = template;
    }

    public static void push(KafkaEvent event){
        KafkaPusher.getInstance().pushEvent(event);
        log.debug("send->{}",event);
    }

}