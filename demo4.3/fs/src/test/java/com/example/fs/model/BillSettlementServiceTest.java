package com.example.fs.model;

import com.example.fs.model.domain.Bill;
import com.example.fs.model.domain.User;
import com.example.fs.model.repository.BankAccountRepository;
import com.example.fs.model.repository.BillRepository;
import com.example.fs.repository.impl.BillRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


class BillSettlementServiceTest {


    @Test
    void pay() {

        BankAccountRepository bankAccountRepository =  Mockito.mock(BankAccountRepository.class);
        Mockito.when(bankAccountRepository.getBankNoByUsername(Mockito.any())).thenReturn("1111111");


        User user1 = new User("user1");
        User user2 = new User("user2");

        BillRepository billRepository = new BillRepositoryImpl();
        BillSettlementService billSettlementService = new BillSettlementService(user1,billRepository,bankAccountRepository);

        Bill bill =  billSettlementService.pay(user2,100);

        assertNotNull(bill);

    }
}