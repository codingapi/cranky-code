package com.codingapi.demo1_4.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Register {

    @Setter
    @Getter
    public static class Request {
        private String username;
        private String password;
        private String email;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Response {
        private String username;
    }
}
