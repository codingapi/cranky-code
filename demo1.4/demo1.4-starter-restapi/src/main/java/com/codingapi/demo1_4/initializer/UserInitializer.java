package com.codingapi.demo1_4.initializer;

import com.codingapi.demo1_4.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserInitializer implements InitializingBean {

    private final UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        userService.register("admin","admin","example@admin.com");
    }
}
