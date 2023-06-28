package com.example.fs.application;

import com.example.fs.controller.pojo.SettlementCommand;
import com.example.fs.model.BillSettlementService;
import com.example.fs.model.domain.Bill;
import com.example.fs.model.domain.User;
import com.example.fs.model.repository.BankAccountRepository;
import com.example.fs.model.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SettlementExecutor {

    private final BankAccountRepository bankAccountRepository;
    private final BillRepository billRepository;

    public Bill settlement(SettlementCommand command){
        User operationUser = new User(command.getOperatorUser());
        User billUser = new User(command.getBillUser());
        BillSettlementService billSettlementService = new BillSettlementService(operationUser,billRepository,bankAccountRepository);
        return billSettlementService.pay(billUser,command.getMoney());
    }

}
