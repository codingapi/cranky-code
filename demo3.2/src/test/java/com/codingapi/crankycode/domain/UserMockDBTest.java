package com.codingapi.crankycode.domain;

import com.codingapi.crankycode.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMockDBTest {

    private UserRepository userRepository;

    @BeforeEach
    void before() {
        userRepository = Mockito.mock(UserRepository.class);
        userRepository.save(Mockito.any());

        Mockito.when(userRepository.findByUsername("admin")).thenReturn(new User("admin"));
    }


    @Test
    void login() {
        User user = new User("admin");
        userRepository.save(user);
        User data = userRepository.findByUsername("admin");
        assertEquals(data.getUsername(),user.getUsername());
    }
}
