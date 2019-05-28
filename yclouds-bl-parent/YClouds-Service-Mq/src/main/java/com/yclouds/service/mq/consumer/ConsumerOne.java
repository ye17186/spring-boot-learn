package com.yclouds.service.mq.consumer;

import com.google.common.base.Charsets;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ye17186
 * @version 2019/4/26 15:48
 */
@Slf4j
// @Component
public class ConsumerOne {

    @Value("${rocketmq.nameSrvAddr}")
    private String nameSrvAddr;

    @Value("${rocketmq.consumer.one.groupName}")
    private String groupName;

    @Value("${rocketmq.consumer.one.topic}")
    private String topic;

    @Getter
    private DefaultMQPushConsumer consumer;

    @PostConstruct
    public void init() {
        consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(nameSrvAddr);
        try {
            consumer.subscribe(topic, "*");
            consumer
                .registerMessageListener((MessageListenerConcurrently) (messages, context) -> {

                    MessageExt msg = messages.get(0);
                    if (msg == null) {
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                    log.info("[RocketMQ]消费消息开始. msgId={}, body={}", msg.getMsgId(),
                        new String(msg.getBody(), Charsets.UTF_8));
                    int times = msg.getReconsumeTimes();
                    try {
                        // 消费此消息
                        log.info("[RocketMQ]成功消费消息. msgId={}", msg.getMsgId());

                    } catch (Exception e) {
                        if (times < 5) {
                            log.warn("[RocketMQ]消费消息异常, 稍后重试{}. msgId={}", msg.getMsgId(), times);
                            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                        } else {
                            log.error("[RocketMQ]消费消息失败, 请人工处理. msgId={}", msg.getMsgId());
                        }
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                });

            consumer.start();
            log.info("[RocketMQ]消费者注册成功. topic={}", topic);
        } catch (MQClientException e) {
            log.error("[RocketMQ]消费者注册失败. topic={}", topic, e);
        }
    }

}
