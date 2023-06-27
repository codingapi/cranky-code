package com.codingapi.crankycode.kafka.message;

import com.codingapi.crankycode.kafka.event.KafkaEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FsProcessApproveMessage extends KafkaEvent {

    private long timestamp;
    private float money;
    private boolean approved;
    private String approverUser;


    public FsProcessApproveMessage() {
        super(MessageConstants.TOPIC_PROCESS_APPROVE);
    }

}
