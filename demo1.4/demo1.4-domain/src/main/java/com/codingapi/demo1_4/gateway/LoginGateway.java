package com.codingapi.demo1_4.gateway;


import com.codingapi.demo1_4.domain.User;

public interface LoginGateway {

    User login(String account, String password);


    boolean support(LoginType loginType);


    enum LoginType{
        USERNAME,
        EMAIL
    }

}
