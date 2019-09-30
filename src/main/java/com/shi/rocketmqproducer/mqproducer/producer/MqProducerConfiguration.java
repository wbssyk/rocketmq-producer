package com.shi.rocketmqproducer.mqproducer.producer;

import com.shi.rocketmqproducer.mqproducer.properties.MqProperties;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MQProducerConfiguration
 * @Author yakun.shi
 * @Date 2019/5/24 9:56
 * @Version 1.0
 **/

@Configuration
public class MqProducerConfiguration {
    public static final Logger LOGGER = LoggerFactory.getLogger(MqProducerConfiguration.class);

    @Autowired
    private MqProperties mqProperties;

    /**
     * @Method
     * @Author yakun.shi
     * @Description 初始化 mq服务端
     * @Return
     * @Date 2019/7/31 17:39
     */
    @Bean
    public DefaultMQProducer getRocketMQProducer() {
        DefaultMQProducer producer;
        producer = new DefaultMQProducer(mqProperties.getGroupName());
        producer.setNamesrvAddr(mqProperties.getNameServerAddress());
        producer.setMaxMessageSize(mqProperties.getMaxMessageSize());
        producer.setSendMsgTimeout(mqProperties.getSendMessageTimeout());
        producer.setRetryTimesWhenSendFailed(mqProperties.getTryTimesWhenSendFailed());
        try {
            producer.start();
            LOGGER.info(String.format("producer is start ! groupName:[%s],namesrvAddr:[%s]"
                    , mqProperties.getGroupName(), mqProperties.getNameServerAddress()));
        } catch (MQClientException e) {
            LOGGER.error(String.format("producer is error {}"
                    , e.getMessage(), e));
            e.printStackTrace();
        }
        return producer;

    }
}
