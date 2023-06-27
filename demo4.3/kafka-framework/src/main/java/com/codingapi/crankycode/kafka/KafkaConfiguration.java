package com.codingapi.crankycode.kafka;

import com.codingapi.crankycode.kafka.event.KafkaEvent;
import com.codingapi.crankycode.kafka.event.KafkaRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@Configuration
public class KafkaConfiguration {

    @Bean(initMethod = "init")
    public KafkaRegister eventRegister(KafkaTemplate<String, KafkaEvent> template){
        return new KafkaRegister(template);
    }

    @Bean
    public RecordMessageConverter recordMessageConverter() {
        return new JsonMessageConverter();
    }

}