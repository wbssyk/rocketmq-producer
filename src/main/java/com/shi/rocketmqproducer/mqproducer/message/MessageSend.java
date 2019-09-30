package com.shi.rocketmqproducer.mqproducer.message;


import com.shi.rocketmqproducer.mqproducer.messagetemplate.MessageTemplate;
import org.apache.rocketmq.client.producer.SendResult;

/**
 * @Author yakun.shi
 * @Description //发送消息接口
 * @Date 2019/6/11 13:19
 **/
public interface MessageSend {
    /**
     * @Author yakun.shi
     * @Description //消息发送
     * @Date 2019/6/11 13:22
     * @Param [message]
     * @return org.apache.mqproducer.client.producer.SendResult
     **/
    SendResult sendMessage(MessageTemplate msg) ;

}
