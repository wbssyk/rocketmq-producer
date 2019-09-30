package com.shi.rocketmqproducer.common.page;

import com.shi.rocketmqproducer.enums.ResponseEnum;

import java.io.Serializable;

public class ServiceResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer result;
    private String message;
    private T data;

    public ServiceResponse() {
        this.setResult(ResponseEnum.SUCCESS.getCode());
        this.setMessage(ResponseEnum.SUCCESS.getMsg());
    }

    public ServiceResponse(T data) {
        this.setResult(ResponseEnum.SUCCESS.getCode());
        this.setMessage(ResponseEnum.SUCCESS.getMsg());
        this.data = data;
    }

    public ServiceResponse(Integer code, String msg) {
        this.result = code;
        this.message = msg;
    }

    public ServiceResponse(ResponseEnum responseEnum) {
        this.setResult(responseEnum.getCode());
        this.setMessage(responseEnum.getMsg());
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public ServiceResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public ServiceResponse createErrorServcieResponse(){
        return new ServiceResponse(ResponseEnum.VISIT_ERROR.getCode(),ResponseEnum.VISIT_ERROR.getMsg());
    }
}
