package com.codingapi.demo1_4.controller;

import com.codingapi.demo1_4.pojo.Login;
import com.codingapi.demo1_4.pojo.Register;
import com.codingapi.demo1_4.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public Login.Response login(@RequestBody Login.Request request) {
        String token = userService.login(request.getLoginType(),
                request.getUsername(),
                request.getPassword());
        return new Login.Response(token);
    }

    @PostMapping("/register")
    public Register.Response register(@RequestBody Register.Request request) {
        userService.register(request.getUsername(), request.getPassword(), request.getEmail());
        return new Register.Response(request.getUsername());
    }

}
