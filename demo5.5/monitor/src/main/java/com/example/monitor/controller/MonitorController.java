package com.example.monitor.controller;

import com.example.monitor.service.MonitorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor")
@AllArgsConstructor
public class MonitorController {

    private final MonitorService monitorService;

    @GetMapping("/increment")
    public int increment() {
        monitorService.increment();
        return monitorService.getValue();
    }

    @GetMapping("/decrement")
    public int decrement() {
        monitorService.decrement();
        return monitorService.getValue();
    }

    @GetMapping("/getValue")
    public int getValue() {
        return monitorService.getValue();
    }

}
