package com.example.fs.model.domain;

import com.codingapi.springboot.framework.event.EventPusher;
import com.example.fs.model.event.BillSettlementEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Bill {

    private User oprationUser;

    private long timestamp;

    private User billUser;

    private float money;

    private String bankNo;

    private String billNo;

    public Bill(User oprationUser,User billUser, float money, String bankNo) {
        this.oprationUser = oprationUser;
        this.timestamp = System.currentTimeMillis();
        this.billNo = "NO"+System.currentTimeMillis();
        this.billUser = billUser;
        this.money = money;
        this.bankNo = bankNo;

        BillSettlementEvent event =new BillSettlementEvent(this);
        EventPusher.push(event);
    }
}
