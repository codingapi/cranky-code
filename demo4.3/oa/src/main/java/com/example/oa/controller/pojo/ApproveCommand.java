package com.example.oa.controller.pojo;

import com.example.oa.model.domain.User;
import lombok.Getter;
import lombok.Setter;

public class ApproveCommand {


    @Getter
    @Setter
    public static class Create {
        private String processName;
        private String username;
        private float money;
        private String approverUser;
    }


    @Setter
    @Getter
    public static class Approve{
        private String processName;
        private String approverUser;
        private boolean approved;

    }
}
