package com.shi.rocketmqproducer.mqproducer.messagetemplate;

import com.shi.rocketmqproducer.enums.MqEnum;
import com.shi.rocketmqproducer.utils.DateUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MessageTemplate implements Serializable {

    private String messageInfo;
    private String ipAddress;
    private String mac;
    private String topic;
    private String tag;
    private String sendTime = DateUtils.dateToString(LocalDateTime.now());
    private String id;

    public MessageTemplate() {
    }

    private MessageTemplate(Builder builder) {
        this.messageInfo = builder.messageInfo;
        this.ipAddress = builder.ipAddress;
        this.mac = builder.mac;
        this.topic = builder.topic;
        this.tag = builder.tag;
        this.id = builder.id;
    }


    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class Builder {
        private String messageInfo;
        private String ipAddress;
        private String mac;
        private String topic = MqEnum.TOPIC.getValue();
        private String tag;
        private String id;
        public Builder(String tag) {
            this.tag = tag;
        }

        public Builder setMessageInfo(String messageInfo) {
            this.messageInfo = messageInfo;
            return this;
        }

        public Builder setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Builder setMac(String mac) {
            this.mac = mac;
            return this;
        }

        public Builder setTopic(String topic) {
            this.topic = topic;
            return this;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public MessageTemplate build() {
            return new MessageTemplate(this);
        }
    }

    @Override
    public String toString() {
        return "MessageTemplate{" +
                "messageInfo='" + messageInfo + '\'' +
                ", topic='" + topic + '\'' +
                ", tag='" + tag + '\'' +
                ", sendTime='" + sendTime + '\'' +
                '}';
    }
}
