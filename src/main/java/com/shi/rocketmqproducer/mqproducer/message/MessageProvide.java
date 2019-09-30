package com.shi.rocketmqproducer.mqproducer.message;

import com.google.gson.Gson;
import com.shi.rocketmqproducer.mqproducer.messagetemplate.MessageTemplate;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @ClassName MessageProvide
 * @Author yakun.shi
 * @Date 2019/6/11 13:25
 * @Version 1.0
 **/
public class MessageProvide implements MessageSend {

    private static Logger logger = LoggerFactory.getLogger(MessageProvide.class);

    private DefaultMQProducer defaultMQProducer;

    private MessageTemplate messageTemplate;

    /**
     * 直接传入消息体的方法发送
     *
     * @param msg
     * @return
     */
    @Override
    public SendResult sendMessage(MessageTemplate msg) {
        Gson gson = new Gson();
        String s = gson.toJson(msg);
        try {
            Message message = new Message(msg.getTopic(),
                    msg.getTag(),
                    s.getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            logger.info("消息message-->messagetemplate={}", msg.toString());
            return send(message);
        } catch (Exception e) {
            logger.error("消息模板编码格式错误");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Method
     * @Author yakun.shi
     * @Description  具体发消息逻辑
     * @Return
     * @Date 2019/7/31 17:41
     */
    public SendResult send(Message message) {
        SendResult sendResult = null;
        try {
            sendResult = defaultMQProducer.send(message);
            logger.info("消息发送成功Result---->result==={}", sendResult);
            return sendResult;
        } catch (Exception e) {
            logger.error("消息发送失败---->errorMessage={}", new Object[]{e.getMessage()});
            e.printStackTrace();
        }
        return sendResult;
    }

    /**
     * @Method
     * @Author yakun.shi
     * @Description 接收 DefaultMQProducer
     * @Return
     * @Date 2019/7/31 17:42
     */
    public void setDefaultMQProducer(DefaultMQProducer defaultMQProducer) {
        this.defaultMQProducer = defaultMQProducer;
    }

    public void setMessageTemplate(MessageTemplate messageTemplate) {
        this.messageTemplate = messageTemplate;
    }
}
