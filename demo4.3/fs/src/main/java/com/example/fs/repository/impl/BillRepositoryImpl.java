package com.example.fs.repository.impl;

import com.example.fs.model.domain.Bill;
import com.example.fs.model.repository.BillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class BillRepositoryImpl implements BillRepository {

    @Override
    public void save(Bill bill) {
      log.info("save bill:{}",bill);
    }
}
