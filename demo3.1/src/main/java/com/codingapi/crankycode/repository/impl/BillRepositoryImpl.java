package com.codingapi.crankycode.repository.impl;

import com.codingapi.crankycode.domain.Bill;
import com.codingapi.crankycode.repository.BillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class BillRepositoryImpl implements BillRepository {

    @Override
    public void save(Bill bill) {
        log.info("save bill==>{}",bill);
    }
}
