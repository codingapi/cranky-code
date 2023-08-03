package com.example.server.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

}
