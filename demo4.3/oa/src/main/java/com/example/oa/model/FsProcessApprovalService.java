package com.example.oa.model;

import com.example.oa.model.domain.FsProcess;
import com.example.oa.model.domain.User;

public class FsProcessApprovalService {

    public void approve(User approverUser,FsProcess fsProcess,boolean approved) {
        fsProcess.checkApprover(approverUser);
        fsProcess.approve(approved);
    }
}
