package com.example.oa.model.event;

import com.codingapi.springboot.framework.event.IEvent;
import com.example.oa.model.domain.FsProcess;
import com.example.oa.model.domain.User;
import lombok.Getter;

@Getter
public class FsProcessApproveEvent implements IEvent {

    private final FsProcess fsProcess;
    private final long timestamp;
    private final float money;
    private final boolean approved;
    private final User approverUser;

    public FsProcessApproveEvent(FsProcess fsProcess) {
        this.fsProcess = fsProcess;
        this.timestamp = System.currentTimeMillis();
        this.approved = fsProcess.isApproved();
        this.approverUser = fsProcess.getApproverUser();
        this.money = fsProcess.getMoney();
    }
}
