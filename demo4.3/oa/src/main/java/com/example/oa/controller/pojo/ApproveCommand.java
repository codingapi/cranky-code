package com.example.oa.controller.pojo;

import lombok.Getter;
import lombok.Setter;

public class ApproveCommand {


    @Getter
    @Setter
    public static class CreateCommand {
        private String processName;
        private String username;
        private float money;
    }
}
