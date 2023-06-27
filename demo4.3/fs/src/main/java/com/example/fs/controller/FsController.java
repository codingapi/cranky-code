package com.example.fs.controller;

import com.example.fs.controller.pojo.SettlementCommand;
import com.example.fs.model.BillSettlementService;
import com.example.fs.model.domain.Bill;
import com.example.fs.model.domain.User;
import com.example.fs.model.repository.BankAccountRepository;
import com.example.fs.model.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fs")
@AllArgsConstructor
public class FsController {

    private final BankAccountRepository bankAccountRepository;
    private final BillRepository billRepository;

    @PostMapping("/settlement")
    public String settlement(@RequestBody SettlementCommand command){
        User operationUser = new User(command.getOprationUser());
        User billUser = new User(command.getBillUser());
        BillSettlementService billSettlementService = new BillSettlementService(operationUser,billRepository,bankAccountRepository);
        Bill bill =  billSettlementService.pay(billUser,100);
        return bill.getBillNo();
    }

}
