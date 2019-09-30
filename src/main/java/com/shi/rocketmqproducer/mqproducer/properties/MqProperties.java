package com.shi.rocketmqproducer.mqproducer.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MqProperties
 * @Author yakun.shi
 * @Date 2019/6/11 16:56
 * @Version 1.0
 **/
@Configuration
@ConfigurationProperties(prefix = "rocketmq.producer")
public class MqProperties {
    private String isOnOff;
    /**
     * 发送同一类消息的设置为同一个group，保证唯一,默认不需要设置，rocketmq会使用ip@pid(pid代表jvm名字)作为唯一标示
     */
    private String groupName;
    private String nameServerAddress;
    /**
     * 消息最大大小，默认4M
     */
    private int maxMessageSize;
    /**
     * 消息发送超时时间，默认3秒
     */
    private int sendMessageTimeout;
    /**
     * 消息发送失败重试次数，默认2次
     */
    private int tryTimesWhenSendFailed;

    public String getIsOnOff() {
        return isOnOff;
    }

    public void setIsOnOff(String isOnOff) {
        this.isOnOff = isOnOff;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getNameServerAddress() {
        return nameServerAddress;
    }

    public void setNameServerAddress(String nameServerAddress) {
        this.nameServerAddress = nameServerAddress;
    }

    public int getMaxMessageSize() {
        return maxMessageSize;
    }

    public void setMaxMessageSize(int maxMessageSize) {
        this.maxMessageSize = maxMessageSize;
    }

    public int getSendMessageTimeout() {
        return sendMessageTimeout;
    }

    public void setSendMessageTimeout(int sendMessageTimeout) {
        this.sendMessageTimeout = sendMessageTimeout;
    }

    public int getTryTimesWhenSendFailed() {
        return tryTimesWhenSendFailed;
    }

    public void setTryTimesWhenSendFailed(int tryTimesWhenSendFailed) {
        this.tryTimesWhenSendFailed = tryTimesWhenSendFailed;
    }
}
