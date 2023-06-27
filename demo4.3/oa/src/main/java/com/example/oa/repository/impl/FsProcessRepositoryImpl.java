package com.example.oa.repository.impl;

import com.example.oa.model.domain.FsProcess;
import com.example.oa.model.repository.FsProcessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class FsProcessRepositoryImpl implements FsProcessRepository {

    private final Map<String,FsProcess> cache = new HashMap<>();

    @Override
    public void save(FsProcess process) {
        cache.put(process.getName(), process);
        log.info("save process:{}",process);
    }

    @Override
    public FsProcess getFsProcessByName(String name) {
        return cache.get(name);
    }
}
