package com.codingapi.demo1_4.pojo;

import com.codingapi.demo1_4.gateway.LoginGateway;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Login {

    @Setter

    public static class Request {
        private LoginGateway.LoginType loginType;

        public LoginGateway.LoginType getLoginType() {
            return loginType==null?LoginGateway.LoginType.USERNAME:loginType;
        }

        @Getter
        private String username;
        @Getter
        private String password;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Response {
        private String token;
    }
}
