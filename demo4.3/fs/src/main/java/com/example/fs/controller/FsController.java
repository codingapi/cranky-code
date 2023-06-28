package com.example.fs.controller;

import com.example.fs.application.SettlementExecutor;
import com.example.fs.controller.pojo.SettlementCommand;
import com.example.fs.model.domain.Bill;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fs")
@AllArgsConstructor
public class FsController {

    private final SettlementExecutor settlementExecutor;

    @PostMapping("/settlement")
    public String settlement(@RequestBody SettlementCommand command){
        Bill bill =  settlementExecutor.settlement(command);
        return bill.getBillNo();
    }

}
