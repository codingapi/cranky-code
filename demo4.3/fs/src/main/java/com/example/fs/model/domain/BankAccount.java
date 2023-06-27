package com.example.fs.model.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BankAccount {

    private User user;
    private String bankNo;

}
