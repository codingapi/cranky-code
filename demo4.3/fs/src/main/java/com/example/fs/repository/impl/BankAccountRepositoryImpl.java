package com.example.fs.repository.impl;

import com.example.fs.model.domain.User;
import com.example.fs.model.repository.BankAccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

    @Override
    public String getBankNoByUsername(User user) {
        return "12345678";
    }
}
