package com.codingapi.crankycode.command;

import lombok.Getter;

public class OrderCommand {


    @Getter
    public static class CreateCommand{

        private String username;
        private String productName;

        public CreateCommand(String username, String productName) {
            this.username = username;
            this.productName = productName;
        }
    }
}
