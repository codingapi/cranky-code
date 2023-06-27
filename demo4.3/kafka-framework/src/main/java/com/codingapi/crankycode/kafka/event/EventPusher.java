package com.codingapi.crankycode.kafka.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
public class EventPusher {

    private final static EventPusher instance = new EventPusher();

    public static EventPusher getInstance() {
        return instance;
    }

    public void pushEvent(BaseEvent event){
        if(template!=null) {
            template.send(event.getTopic(), event);
        }
    }

    private KafkaTemplate<String, BaseEvent> template;

    void init(KafkaTemplate<String, BaseEvent> template){
        this.template = template;
    }

    public static void push(BaseEvent event){
        EventPusher.getInstance().pushEvent(event);
        log.debug("send->{}",event);
    }

}