package com.yclouds.service.mq.controller;


import com.yclouds.myhelper.context.SpringContextHandler;
import com.yclouds.myhelper.context.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ye17186
 * @version 2019/4/26 16:11
 */
@Slf4j
@RestController
@RequestMapping("/mq")
public class MqController {

    // @Autowired
    // MyProducer myProducer;

    // @Autowired
    // ProducerTwo producerTwo;

    @RequestMapping("")
    public String sendMsg() {

        // JmsUtils.send("topic-one", "topic one message.");
        // JmsUtils.send("topic-two", "topic two message.");
        System.out.println(SpringUtils.getBean(MqController.class));
        System.out.println(SpringUtils.getBean(SpringContextHandler.class));

        System.out.println(1 / 0);

        return "OK";

    }

}
