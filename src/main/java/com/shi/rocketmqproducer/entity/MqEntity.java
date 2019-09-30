package com.shi.rocketmqproducer.entity;

import java.util.Date;

/**
 * @program: rocketmq-producer
 * @description: ss
 * @author: yaKun.shi
 * @create: 2019-09-30 09:00
 **/
public class MqEntity {

    private String id;

    private String ipAddress;

    private String mac;

    private String jsError;

    private Integer checkStatus;

    private String remark;

    private Date createtime;

    private Date lastCheckTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getJsError() {
        return jsError;
    }

    public void setJsError(String jsError) {
        this.jsError = jsError;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastCheckTime() {
        return lastCheckTime;
    }

    public void setLastCheckTime(Date lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }
}
