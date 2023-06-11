package com.codingapi.crankycode.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void resetPassword() {
        User user = new User("test");
        user.resetPassword("123456");
        assertEquals("123456", user.getPassword());
    }

    @Test
    void changePassword() {
        User user = new User("test");
        user.changePassword("123456", "12345678");
        assertEquals("12345678", user.getPassword());
    }

    @Test
    void match() {
        User user = new User("test");
        assertTrue(user.match("123456"));
    }

    @Test
    void getUsername() {
        User user = new User("test");
        assertEquals("test", user.getUsername());
    }

    @Test
    void getPassword() {
        User user = new User("test");
        assertEquals("123456", user.getPassword());
    }
}