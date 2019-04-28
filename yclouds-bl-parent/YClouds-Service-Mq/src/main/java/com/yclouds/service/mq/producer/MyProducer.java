package com.yclouds.service.mq.producer;

import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息生产者One
 *
 * @author yemeng-lhq
 * @version 2019/4/26 15:30
 */
@Slf4j
@Component
public class MyProducer implements IProducer {


    @Value("${rocketmq.nameSrvAddr}")
    private String nameSrvAddr;

    @Value("${rocketmq.producer.groupName}")
    private String groupName;

    @Getter
    private DefaultMQProducer producer;

    /**
     * 注册MQ生产者
     */
    @PostConstruct
    public void init() {
        producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(nameSrvAddr);
        producer.setRetryTimesWhenSendAsyncFailed(3);
        producer.setRetryTimesWhenSendFailed(3);
        try {
            producer.start();
            log.info("[RocketMQ]注册生产者成功.");
        } catch (MQClientException e) {
            log.error("[RocketMQ]注册生产者失败", e);
        }
    }
}
