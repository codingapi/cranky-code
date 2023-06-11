package com.codingapi.crankycode.repository.impl;

import com.codingapi.crankycode.domain.User;
import com.codingapi.crankycode.repository.UserRepository;
import com.codingapi.crankycode.repository.convert.UserConvertor;
import com.codingapi.crankycode.repository.jpa.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserEntityRepository userEntityRepository;

    @Override
    public void save(User user) {
        userEntityRepository.save(UserConvertor.convert(user));
    }

    @Override
    public User findByUsername(String username) {
        return UserConvertor.convert(userEntityRepository.findByUsername(username));
    }
}
