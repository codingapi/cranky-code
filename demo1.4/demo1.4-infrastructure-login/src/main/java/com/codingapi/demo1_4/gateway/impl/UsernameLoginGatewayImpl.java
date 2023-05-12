package com.codingapi.demo1_4.gateway.impl;

import com.codingapi.demo1_4.domain.User;
import com.codingapi.demo1_4.gateway.LoginGateway;
import com.codingapi.demo1_4.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsernameLoginGatewayImpl implements LoginGateway {

    private final UserRepository userRepository;

    @Override
    public boolean support(LoginType loginType) {
        return loginType == LoginType.USERNAME;
    }

    @Override
    public User login(String account, String password) {
        User user = userRepository.getByUsername(account);
        if (user == null) {
            throw new RuntimeException("user not found");
        }
        if(user.matchPassword(password)){
            return user;
        }
        throw new RuntimeException("user password error");
    }
}
