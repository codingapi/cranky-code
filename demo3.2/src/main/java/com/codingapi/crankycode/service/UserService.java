package com.codingapi.crankycode.service;

import com.codingapi.crankycode.domain.User;
import com.codingapi.crankycode.exception.UserBizException;
import com.codingapi.crankycode.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User login(String username, String password){
        User user =  userRepository.findByUsername(username);
        if(user == null){
            throw new UserBizException("user not found");
        }
        if(user.match(password)){
            return user;
        }
        throw new UserBizException("password error");
    }
}
