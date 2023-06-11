package com.codingapi.crankycode.exception;

public class UserBizException extends RuntimeException{

    public UserBizException() {
    }

    public UserBizException(String message) {
        super(message);
    }

    public UserBizException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserBizException(Throwable cause) {
        super(cause);
    }

    public UserBizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
