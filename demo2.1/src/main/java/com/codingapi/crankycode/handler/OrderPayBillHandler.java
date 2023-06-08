package com.codingapi.crankycode.handler;

import com.codingapi.crankycode.domain.Bill;
import com.codingapi.crankycode.domain.Order;
import com.codingapi.crankycode.domain.User;
import com.codingapi.crankycode.event.OrderPayEvent;
import com.codingapi.crankycode.repository.BillRepository;
import com.codingapi.springboot.framework.handler.Handler;
import com.codingapi.springboot.framework.handler.IHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Handler
@AllArgsConstructor
public class OrderPayBillHandler implements IHandler<OrderPayEvent> {

    private final BillRepository billRepository;

    @Override
    public void handler(OrderPayEvent event) {
        log.info("order pay event:{}",event);
        Order order =  event.getOrder();
        User user = event.getOrder().getUser();

        Bill bill = new Bill(order,user);
        billRepository.save(bill);
    }
}
