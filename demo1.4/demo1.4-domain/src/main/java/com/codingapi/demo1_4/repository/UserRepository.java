package com.codingapi.demo1_4.repository;


import com.codingapi.demo1_4.domain.User;

public interface UserRepository {

    User getByUsername(String username);

    User getByEmail(String email);

    void save(User user);

}
