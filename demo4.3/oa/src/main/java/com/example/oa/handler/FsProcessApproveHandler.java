package com.example.oa.handler;

import com.codingapi.crankycode.kafka.event.KafkaPusher;
import com.codingapi.crankycode.kafka.message.FsProcessApproveMessage;
import com.codingapi.springboot.framework.handler.Handler;
import com.codingapi.springboot.framework.handler.IHandler;
import com.example.oa.model.event.FsProcessApproveEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Handler
public class FsProcessApproveHandler implements IHandler<FsProcessApproveEvent> {
    @Override
    public void handler(FsProcessApproveEvent event) {
      log.info("event:{}",event);

        FsProcessApproveMessage message = new FsProcessApproveMessage();
        message.setApproved(event.isApproved());
        message.setApproverUser(event.getApproverUser().getUsername());
        message.setMoney(event.getMoney());
        message.setTimestamp(event.getTimestamp());
        KafkaPusher.push(message);
    }

}
