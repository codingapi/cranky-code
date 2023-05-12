package com.codingapi.demo1_4.service;

import com.codingapi.demo1_4.domain.User;
import com.codingapi.demo1_4.event.UserRegisterEvent;
import com.codingapi.demo1_4.gateway.LoginGateway;
import com.codingapi.demo1_4.repository.UserRepository;
import com.codingapi.springboot.framework.event.EventPusher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final List<LoginGateway> loginServices;

    public String login(LoginGateway.LoginType loginType, String account, String password) {
        for (LoginGateway loginService : loginServices) {
            if (loginService.support(loginType)) {
                User user = loginService.login(account, password);
                return user.createToken();
            }
        }
        throw new RuntimeException("login error");
    }

    public void register(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.verify();
        userRepository.save(user);

        EventPusher.push(new UserRegisterEvent(username));
    }
}
