package com.yclouds.service.mq.controller;

import com.yclouds.service.mq.producer.MyProducer;
import com.yclouds.service.mq.utils.JmsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yemeng-lhq
 * @version 2019/4/26 16:11
 */
@Slf4j
@RestController
@RequestMapping("/mq")
public class MqController {

    @Autowired
    MyProducer myProducer;

    // @Autowired
    // ProducerTwo producerTwo;

    @RequestMapping("")
    public String sendMsg() {

        JmsUtils.send("topic-one", "topic one message.");
        JmsUtils.send("topic-two", "topic two message.");
        return "OK";

    }

}
