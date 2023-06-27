package com.example.fs.model.event;

import com.codingapi.springboot.framework.event.IEvent;
import com.example.fs.model.domain.Bill;
import lombok.AllArgsConstructor;

public class BillSettlementEvent implements IEvent {

    private final Bill bill;
    private final long timestamp;

    public BillSettlementEvent(Bill bill) {
        this.bill = bill;
        this.timestamp= System.currentTimeMillis();
    }
}
