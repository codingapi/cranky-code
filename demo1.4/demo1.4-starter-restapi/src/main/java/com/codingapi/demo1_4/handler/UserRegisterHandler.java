package com.codingapi.demo1_4.handler;

import com.codingapi.demo1_4.event.UserRegisterEvent;
import com.codingapi.springboot.framework.handler.IHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class UserRegisterHandler implements IHandler<UserRegisterEvent> {

    @Override
    public void handler(UserRegisterEvent event) {
        log.info("user register event:{}",event);
    }
}
