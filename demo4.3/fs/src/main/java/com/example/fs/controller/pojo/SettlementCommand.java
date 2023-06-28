package com.example.fs.controller.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SettlementCommand {

    private String operatorUser;

    private String billUser;

    private float money;
}
