package com.example.oa.controller;

import com.example.oa.controller.pojo.ApproveCommand;
import com.example.oa.model.domain.FsProcess;
import com.example.oa.model.domain.User;
import com.example.oa.model.repository.FsProcessRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/oa")
public class OaController {

    private FsProcessRepository processRepository;

    @PostMapping("/createProcess")
    public void createProcess(@RequestBody ApproveCommand.CreateCommand command) {
        User user = new User(command.getUsername());
        FsProcess fsProcess = new FsProcess(command.getProcessName(), user, command.getMoney());


    }


}
