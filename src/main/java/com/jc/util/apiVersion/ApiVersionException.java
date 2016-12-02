package com.jc.util.apiVersion;

/**
 * 版本控制异常
 * Created by jasonzhu on 2016/11/30.
 */
public class ApiVersionException extends RuntimeException {

    public ApiVersionException(String message) {
        super(message);
    }

    public ApiVersionException(String message, Throwable cause) {
        super(message, cause);
    }
}
