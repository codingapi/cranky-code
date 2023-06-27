package com.example.fs.model;

import com.example.fs.model.domain.Bill;
import com.example.fs.model.domain.User;
import com.example.fs.model.repository.BankAccountRepository;
import com.example.fs.model.repository.BillRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BillSettlementService {

    private final User oprationUser;

    private final BillRepository billRepository;

    private final BankAccountRepository bankAccountRepository;

    public Bill pay(User billUser,float money){
        String bankNo = bankAccountRepository.getBankNoByUsername(billUser);
        Bill bill = new Bill(oprationUser,billUser,money,bankNo);
        billRepository.save(bill);
        return bill;
    }


}
