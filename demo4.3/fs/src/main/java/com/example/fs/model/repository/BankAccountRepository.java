package com.example.fs.model.repository;

import com.example.fs.model.domain.User;

public interface BankAccountRepository {

    String getBankNoByUsername(User user);

}
