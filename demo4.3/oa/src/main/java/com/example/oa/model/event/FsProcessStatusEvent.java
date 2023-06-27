package com.example.oa.model.event;

import com.codingapi.springboot.framework.event.IEvent;
import com.example.oa.model.domain.FsProcess;
import lombok.Getter;

@Getter
public class FsProcessStatusEvent implements IEvent {

    private final FsProcess fsProcess;
    private final long timestamp;
    private final FsProcess.Status status;

    public FsProcessStatusEvent(FsProcess fsProcess) {
        this.fsProcess = fsProcess;
        this.timestamp = System.currentTimeMillis();
        this.status = fsProcess.getStatus();
    }
}
