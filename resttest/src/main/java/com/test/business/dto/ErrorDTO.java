package com.test.business.dto;

import org.springframework.stereotype.Component;

/**
 * @author Samuel Martinez
 * @since 11/05/2017.
 */
@Component
public class ErrorDTO<T> {
    private String message;
    private String errorCode;
    private T data;

    public ErrorDTO () {
    }

    public ErrorDTO (String errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorDTO (String errorCode,String message) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public ErrorDTO (String errorCode, T data) {
        this.errorCode = errorCode;
        this.data = data;
    }

    public ErrorDTO (String errorCode, String message, T data) {
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public String getErrorCode () {
        return errorCode;
    }

    public void setErrorCode (String errorCode) {
        this.errorCode = errorCode;
    }

    public T getData () {
        return data;
    }

    public void setData (T data) {
        this.data = data;
    }
}
