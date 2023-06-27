package com.codingapi.crankycode.kafka;

import com.codingapi.crankycode.kafka.event.BaseEvent;
import com.codingapi.crankycode.kafka.event.EventRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@Configuration
public class KafkaConfiguration {

    @Bean(initMethod = "init")
    public EventRegister eventRegister(KafkaTemplate<String, BaseEvent> template){
        return new EventRegister(template);
    }

    @Bean
    public RecordMessageConverter recordMessageConverter() {
        return new JsonMessageConverter();
    }

}