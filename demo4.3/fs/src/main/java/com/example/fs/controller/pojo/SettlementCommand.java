package com.example.fs.controller.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SettlementCommand {

    private String oprationUser;
    private String billUser;

    private float money;
}
