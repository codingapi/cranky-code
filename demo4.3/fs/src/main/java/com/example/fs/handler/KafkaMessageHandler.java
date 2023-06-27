package com.example.fs.handler;

import com.example.fs.message.MessageConstants;
import com.example.fs.message.TestMsg;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaMessageHandler {

    @KafkaListener(groupId = "fs-group",topics = MessageConstants.TEST_TOPIC)
    public void handler(TestMsg testMsg){
        log.info("msg:{}",testMsg);
    }
}
