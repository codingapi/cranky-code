package com.example.monitor.service;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MonitorService {

    private final AtomicInteger value = new AtomicInteger(0);

    public MonitorService(MeterRegistry registry) {
        Gauge.builder("monitor_value", value, AtomicInteger::get)
                .description("monitor_value is a gauge for monitor value")
                .tags("monitor_tag","monitor_value") // Optional tags
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
