package com.codingapi.crankycode.controller;

import com.codingapi.crankycode.controller.pojo.UserRequest;
import com.codingapi.crankycode.domain.User;
import com.codingapi.crankycode.service.UserService;
import com.codingapi.springboot.framework.dto.response.SingleResponse;
import com.codingapi.springboot.framework.exception.LocaleMessageException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/login")
    public SingleResponse<User> login(@RequestBody UserRequest userRequest){
        try {
            return SingleResponse.of(userService.login(userRequest.getUsername(), userRequest.getPassword()));
        }catch (Exception e){
            throw new LocaleMessageException("login.error",e.getMessage());
        }
    }
}
