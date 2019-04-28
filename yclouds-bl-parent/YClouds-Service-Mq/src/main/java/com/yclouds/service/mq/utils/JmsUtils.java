package com.yclouds.service.mq.utils;

import com.google.common.base.Charsets;
import com.yclouds.service.mq.producer.MyProducer;
import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yemeng-lhq
 * @version 2019/4/26 16:15
 */
@Slf4j
@Component
public class JmsUtils {

    private JmsUtils() {
    }

    @Autowired
    private MyProducer myProducer;

    private static DefaultMQProducer producer;

    @PostConstruct
    private void init() {
        producer = myProducer.getProducer();
    }

    /**
     * 构建MQ消息对象
     *
     * @param topic 主题
     * @param body 消息体
     * @return MQ消息对象
     */
    public static Message buildMqMsg(@Nonnull String topic, @Nonnull String body) {
        return new Message(topic, body.getBytes(Charsets.UTF_8));
    }

    public static void send(@Nonnull String topic, @Nonnull String body) {
        try {
            producer.sendOneway(buildMqMsg(topic, body));
            log.info("[RocketMQ]消息发送成功. topic={}, body={}", topic, body);
        } catch (Exception e) {
            log.error("[RocketMQ]消息发送失败. topic={}, body={}", topic, body, e);
        }
    }
}
