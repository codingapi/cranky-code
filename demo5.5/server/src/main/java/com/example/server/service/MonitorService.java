package com.example.server.service;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MonitorService {

    private final AtomicInteger value = new AtomicInteger(0);

    public MonitorService(MeterRegistry registry) {
        Gauge.builder("request_count", value, AtomicInteger::get)
                .description("request_count is a gauge for request count")
                .tags("request_count_tag","request_count") // Optional tags
                .register(registry);
    }

    public void increment() {
        value.incrementAndGet();
    }

    public void decrement() {
        value.decrementAndGet();
    }

    public int getValue() {
        return value.get();
    }

}
