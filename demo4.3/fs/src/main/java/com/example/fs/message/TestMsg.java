package com.example.fs.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TestMsg {

    private String topic;

    private long ts;

    private String msg;
}
