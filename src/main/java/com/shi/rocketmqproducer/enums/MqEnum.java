package com.shi.rocketmqproducer.enums;

/**
 * @program: dg-cloud
 * @description: mq常量
 * @author: yaKun.shi
 * @create: 2019-07-31 16:50
 **/
public enum MqEnum {

    TOPIC("dg_client_topic","mq主题"),
    TAG1("error_log","网银登录失败接口服务log的tag"),
    TAG2("client_log","网银客户端其他log的tag");

    private String value;
    private String description;


    MqEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
