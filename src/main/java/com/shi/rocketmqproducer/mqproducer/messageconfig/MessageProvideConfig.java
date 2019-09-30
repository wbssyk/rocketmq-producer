package com.shi.rocketmqproducer.mqproducer.messageconfig;

import com.dg.cloudservice.mqproducer.message.MessageProvide;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MessageProvideConfig
 * @Author yakun.shi
 * @Date 2019/6/11 13:34
 * @Version 1.0
 * @Description 配置mq到spring中
 **/
@Configuration
public class MessageProvideConfig {

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    /**
     * @Method
     * @Author yakun.shi
     * @Description 注入 mq 服务端
     * @Return
     * @Date 2019/7/31 17:39
     */
    @Bean
    public MessageProvide messageProvide(){
        MessageProvide messageProvide = new MessageProvide();
        messageProvide.setDefaultMQProducer(defaultMQProducer);
        return messageProvide;
    }
}
