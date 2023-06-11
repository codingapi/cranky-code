package com.codingapi.crankycode.repository.impl;

import com.codingapi.crankycode.domain.Order;
import com.codingapi.crankycode.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public void save(Order order) {
        log.info("save order {}.",order);
    }
}
