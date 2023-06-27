package com.example.oa.controller;

import com.example.oa.controller.pojo.ApproveCommand;
import com.example.oa.model.FsProcessApprovalService;
import com.example.oa.model.domain.FsProcess;
import com.example.oa.model.domain.User;
import com.example.oa.model.repository.FsProcessRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/oa")
@AllArgsConstructor
public class OaController {

    private FsProcessRepository processRepository;

    @PostMapping("/createProcess")
    public boolean createProcess(@RequestBody ApproveCommand.Create command) {
        User user = new User(command.getUsername());
        FsProcess fsProcess = new FsProcess(command.getProcessName(), user, command.getMoney());
        User appoverUser = new User(command.getApproverUser());
        fsProcess.setApproverUser(appoverUser);
        processRepository.save(fsProcess);
        return true;
    }


    @PostMapping("/approve")
    public boolean approve(@RequestBody ApproveCommand.Approve command) {
        User approverUser = new User(command.getApproverUser());
        FsProcess fsProcess =  processRepository.getFsProcessByName(command.getProcessName());
        FsProcessApprovalService approvalService = new FsProcessApprovalService(approverUser,fsProcess);
        approvalService.approve(command.isApproved());
        return true;
    }

}
