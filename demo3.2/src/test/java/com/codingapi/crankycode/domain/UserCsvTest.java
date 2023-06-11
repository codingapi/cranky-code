package com.codingapi.crankycode.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCsvTest {

    @ParameterizedTest
    @CsvFileSource(
            numLinesToSkip = 1,
            files = "src/test/resources/junit/user/users.csv")
    void matchPassword(String username,String password) {
        User user = new User(username);
        assertTrue(user.match(password));
    }
}
