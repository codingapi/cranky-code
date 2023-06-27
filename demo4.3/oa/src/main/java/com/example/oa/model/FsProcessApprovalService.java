package com.example.oa.model;

import com.example.oa.model.domain.FsProcess;
import com.example.oa.model.domain.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FsProcessApprovalService {

    private final User approverUser;
    private final FsProcess fsProcess;

    public void approve(boolean approved) {
        fsProcess.checkApprover(approverUser);
        fsProcess.approve(approved);
    }


}
