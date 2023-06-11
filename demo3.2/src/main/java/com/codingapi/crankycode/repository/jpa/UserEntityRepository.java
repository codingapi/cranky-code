package com.codingapi.crankycode.repository.jpa;

import com.codingapi.crankycode.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity,String> {

    UserEntity findByUsername(String username);

}
