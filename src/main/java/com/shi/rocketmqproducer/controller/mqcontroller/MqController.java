package com.shi.rocketmqproducer.controller.mqcontroller;

import com.shi.rocketmqproducer.common.page.ServiceResponse;
import com.shi.rocketmqproducer.entity.MqEntity;
import com.shi.rocketmqproducer.mqproducer.message.MessageSend;
import com.shi.rocketmqproducer.mqproducer.messagetemplate.MessageTemplate;
import com.shi.rocketmqproducer.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.shi.rocketmqproducer.enums.MqEnum.TAG1;


/**
 * @ClassName MqController
 * @Author yakun.shi
 * @Date 2019/6/11 16:10
 * @Version 1.0
 **/
@RestController
@RequestMapping("mq")
public class MqController {

    @Autowired
    private MessageSend messageSend;


    /**
     * @Method
     * @Author yakun.shi
     * @Description 收集错误日志
     * @Return
     * @Date 2019/8/1 8:41
     */
    @PostMapping("error_log")
    public ServiceResponse collectErrorLog(@RequestBody MqEntity mqEntity) {
        MessageTemplate messageTemplate = new MessageTemplate
                .Builder(TAG1.getValue())
                .setIpAddress(mqEntity.getIpAddress())
                .setMac(mqEntity.getMac())
                .setMessageInfo(mqEntity.getJsError())
                .setId(UUIDUtil.getUUID())
                .build();
        messageSend.sendMessage(messageTemplate);
        return new ServiceResponse();
    }
}
