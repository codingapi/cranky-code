package com.example.server.controller;

import com.example.server.service.MonitorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DemoController {

    private MonitorService monitorService;

    @GetMapping("/hello")
    public String hello() {
        monitorService.increment();
        return "Hello World!";
    }

    @GetMapping("/value")
    public int value() {
        return monitorService.getValue();
    }

}
