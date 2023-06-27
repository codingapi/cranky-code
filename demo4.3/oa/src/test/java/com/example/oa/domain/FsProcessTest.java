package com.example.oa.domain;

import com.example.oa.model.FsProcessApprovalService;
import com.example.oa.model.domain.FsProcess;
import com.example.oa.model.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FsProcessTest {

    @Test
    void approve() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        FsProcess fsProcess = new FsProcess("process1", user1, 1000);
        fsProcess.setApproverUser(user2);

        FsProcessApprovalService fsProcessApprovalService = new FsProcessApprovalService(user2,fsProcess);
        fsProcessApprovalService.approve(true);
        assertTrue(fsProcess.isApproved());
    }

    @Test
    void approve2() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        FsProcess fsProcess = new FsProcess("process1", user1, 1000);
        fsProcess.setApproverUser(user2);

        FsProcessApprovalService fsProcessApprovalService = new FsProcessApprovalService(user2,fsProcess);
        fsProcessApprovalService.approve(false);

        assertFalse(fsProcess.isApproved());
    }

    @Test
    void approve3() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        FsProcess fsProcess = new FsProcess("process1", user1, 1000);
        fsProcess.setApproverUser(user2);
        FsProcessApprovalService fsProcessApprovalService = new FsProcessApprovalService(user1,fsProcess);

        assertThrows(RuntimeException.class, () -> {
            fsProcessApprovalService.approve(true);
        });
    }
}