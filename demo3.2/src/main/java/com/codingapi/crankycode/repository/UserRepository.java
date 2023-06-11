package com.codingapi.crankycode.repository;

import com.codingapi.crankycode.domain.User;

public interface UserRepository {

    void save(User user);

    User findByUsername(String username);

}
