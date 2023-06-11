package com.codingapi.crankycode.repository.convert;

import com.codingapi.crankycode.domain.User;
import com.codingapi.crankycode.repository.entity.UserEntity;

public class UserConvertor {

    public static UserEntity convert(User user){
        if (user == null) return null;
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }

    public static User convert(UserEntity userEntity){
        if (userEntity == null) return null;
        User user = new User(userEntity.getUsername());
        user.resetPassword(userEntity.getPassword());
        return user;
    }

}
