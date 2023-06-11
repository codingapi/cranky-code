package com.codingapi.crankycode.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class UserEntity {

    @Id
    private String username;
    private String password;
}
