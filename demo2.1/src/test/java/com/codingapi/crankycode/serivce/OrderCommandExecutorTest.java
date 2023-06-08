package com.codingapi.crankycode.serivce;

import com.codingapi.crankycode.command.OrderCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderCommandExecutorTest {

    @Autowired
    private OrderExecutor orderExecutor;

    @Test
    void createOrder() {
        OrderCommand.CreateCommand command = new OrderCommand.CreateCommand("小强","手机");
        orderExecutor.createOrder(command);
    }
}