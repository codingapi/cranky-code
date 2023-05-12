package com.codingapi.demo1_4.repository.impl;

import com.codingapi.demo1_4.domain.User;
import com.codingapi.demo1_4.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> usernameCache = new ConcurrentHashMap<>();
    private final Map<String,User> emailCache = new ConcurrentHashMap<>();

    @Override
    public User getByUsername(String username) {
        return usernameCache.get(username);
    }

    @Override
    public void save(User user) {
        usernameCache.put(user.getUsername(),user);
        emailCache.put(user.getEmail(),user);
    }

    @Override
    public User getByEmail(String email) {
        return emailCache.get(email);
    }
}
