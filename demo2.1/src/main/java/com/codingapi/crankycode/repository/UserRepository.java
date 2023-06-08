package com.codingapi.crankycode.repository;

import com.codingapi.crankycode.domain.User;

public interface UserRepository {


    User getUserByName(String name);

}
