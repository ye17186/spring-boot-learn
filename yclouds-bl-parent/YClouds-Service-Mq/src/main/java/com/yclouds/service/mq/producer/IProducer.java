package com.yclouds.service.mq.producer;

import com.google.common.base.Charsets;
import org.apache.rocketmq.common.message.Message;

/**
 * @author ye17186
 * @version 2019/4/26 16:43
 */
public interface IProducer {

    default Message buildMsg(String topic, String body) {
        return new Message(topic, body.getBytes(Charsets.UTF_8));
    }
}
