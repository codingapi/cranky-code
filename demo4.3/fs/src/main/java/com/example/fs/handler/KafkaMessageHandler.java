package com.example.fs.handler;

import com.codingapi.crankycode.kafka.message.MessageConstants;
import com.codingapi.crankycode.kafka.message.TestMsg;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaMessageHandler {

    @KafkaListener(groupId = MessageConstants.GROUP_FS_NAME,topics = MessageConstants.TOPIC_TEST)
    public void handler(TestMsg testMsg){
        log.info("msg:{}",testMsg);
    }

}
