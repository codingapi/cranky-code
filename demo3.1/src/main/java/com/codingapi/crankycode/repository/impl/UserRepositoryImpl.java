package com.codingapi.crankycode.repository.impl;

import com.codingapi.crankycode.domain.User;
import com.codingapi.crankycode.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public User getUserByName(String name) {
        return new User(name);
    }
}
