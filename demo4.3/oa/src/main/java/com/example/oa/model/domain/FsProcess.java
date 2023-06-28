package com.example.oa.model.domain;

import com.codingapi.springboot.framework.event.EventPusher;
import com.example.oa.model.event.FsProcessApproveEvent;
import com.example.oa.model.event.FsProcessStatusEvent;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FsProcess {

    private final String name;
    private User createUser;
    private User approverUser;
    private Status status;
    private float money;
    private String desc;
    private long createTimestamp;
    private long approveTimestamp;

    public FsProcess(String name, User createUser, float money) {
        this.name = name;
        this.createUser = createUser;
        this.money = money;
        this.status = Status.NEW;
        this.createTimestamp = System.currentTimeMillis();
        this.pushStatusEvent();
    }

    public void checkApprover(User user) {
        if (!this.approverUser.equals(user)) {
            throw new RuntimeException("not the same approver");
        }
    }


    private void pushStatusEvent() {
        EventPusher.push(new FsProcessStatusEvent(this));
    }

    private void pushApproveEvent() {
        EventPusher.push(new FsProcessApproveEvent(this));
    }

    public enum Status {
        NEW, APPROVING, APPROVED, REJECTED
    }

    public void setApproverUser(User approverUser) {
        if (createUser == approverUser) {
            throw new RuntimeException("can not set approver to the same user");
        }

        this.approverUser = approverUser;
        this.status = Status.APPROVING;
        this.pushStatusEvent();
    }

    public void approve(boolean approved) {
        if (approved) {
            this.status = Status.APPROVED;
            this.approveTimestamp = System.currentTimeMillis();
            this.pushApproveEvent();
        } else {
            this.status = Status.REJECTED;
        }
        this.pushStatusEvent();
    }

    public boolean isApproved() {
        return this.status == Status.APPROVED;
    }
}
