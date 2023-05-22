package com.codingapi.demo1_4.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class UserTest {


    @ParameterizedTest
    @CsvFileSource(
            numLinesToSkip = 1,
            files = "src/test/resources/junit/user/users.csv")
    void matchPassword(String email,String username,String password,String match) {
        User user = new User(email,username,password);
        assertTrue(user.matchPassword(match));
    }

    @ParameterizedTest
    @CsvFileSource(
            numLinesToSkip = 1,
            files = "src/test/resources/junit/user/users.csv")
    void createToken(String email,String username,String password) {
        User user = new User(email,username,password);
        assertEquals(user.createToken(),"token:"+username);
    }

    @ParameterizedTest
    @CsvFileSource(
            numLinesToSkip = 1,
            files = "src/test/resources/junit/user/users_verify.csv")
    void verify(String email,String username,String password) {
        User user = new User(email,username,password);
        assertThrows(RuntimeException.class, user::verify);
    }

}