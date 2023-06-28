package com.example.fs.handler;

import com.codingapi.crankycode.kafka.message.FsProcessApproveMessage;
import com.codingapi.crankycode.kafka.message.MessageConstants;
import com.codingapi.crankycode.kafka.message.TestMessage;
import com.example.fs.application.SettlementExecutor;
import com.example.fs.controller.pojo.SettlementCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaMessageHandler {

    private final SettlementExecutor settlementExecutor;

    private final static String DEFAULT_OPERATOR_USER = "operator";

    @KafkaListener(groupId = MessageConstants.GROUP_FS_NAME,topics = MessageConstants.TOPIC_TEST)
    public void handlerTestMsg(TestMessage testMessage){
        log.info("msg:{}", testMessage);
    }


    @KafkaListener(groupId = MessageConstants.GROUP_FS_NAME,topics = MessageConstants.TOPIC_PROCESS_APPROVE)
    public void handlerFsProcessApproveMessage(FsProcessApproveMessage message){
        log.info("msg:{}",message);
        SettlementCommand command = new SettlementCommand();
        command.setMoney(message.getMoney());
        command.setBillUser(message.getApproverUser());
        command.setOperatorUser(DEFAULT_OPERATOR_USER);
        settlementExecutor.settlement(command);
    }

}
