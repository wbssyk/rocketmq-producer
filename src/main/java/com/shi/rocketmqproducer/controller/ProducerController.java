package com.shi.rocketmqproducer.controller;

import com.google.gson.Gson;
import com.shi.rocketmqproducer.entity.MessageTemplate;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * @ClassName ProducerController
 * @Author yakun.shi
 * @Date 2019/5/24 15:01
 * @Version 1.0
 **/
@RestController
public class ProducerController {

    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    /**使用RocketMq的生产者*/
    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @GetMapping("send_tag1")
    public void sendTag1() throws MQClientException, RemotingException, MQBrokerException, InterruptedException, UnsupportedEncodingException {
        // 创建消息，并指定Topic，Tag和消息体\

            MessageTemplate messageTemplate = new MessageTemplate();
            messageTemplate.setId(UUID.randomUUID().toString());
            messageTemplate.setSendMessageType("Tag-1");
            messageTemplate.setMessageinfo("测试消息队列压力");
            Gson gson = new Gson();
            String s = gson.toJson(messageTemplate);
            Message msg = new Message("Topic-2" /* Topic */,
                    "Tag-1","Key-1",
                    s.getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            // 发送消息到一个Broker
            SendResult sendResult = defaultMQProducer.send(msg);


        // 通过sendResult返回消息是否成功送达
        System.out.printf("%s%n", sendResult);
        // 如果不再发送消息，关闭Producer实例。
    }

    @GetMapping("send_tag2")
    public void sendTag2() throws MQClientException, RemotingException, MQBrokerException, InterruptedException, UnsupportedEncodingException {
        // 创建消息，并指定Topic，Tag和消息体
        for (int i = 0; i <10; i++) {
            MessageTemplate messageTemplate = new MessageTemplate();
            messageTemplate.setId(UUID.randomUUID().toString());
            messageTemplate.setSendMessageType("Tag-2");
            messageTemplate.setMessageinfo("测试消息队列压力"+i);
            Gson gson = new Gson();
            String s = gson.toJson(messageTemplate);
            Message msg = new Message("Topic-3" /* Topic */,
                    "Tag-2","Key-2",
                    s.getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            // 发送消息到一个Broker
            SendResult sendResult = defaultMQProducer.send(msg);
        }

        // 如果不再发送消息，关闭Producer实例。

    }
}
