package com.yclouds.demo.email.controller;

import com.yclouds.demo.email.model.EmailModel;
import com.yclouds.demo.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.yclouds.demo.email.controller.EmailController
 *
 * @author yemeng-lhq
 * @version 2019/6/18 21:52
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/send1")
    public String sendMail() {

        EmailModel emailModel = new EmailModel();
        emailModel.setTo("aaa@163.com");
        emailModel.setSubject("the email subject");
        emailModel.setContent("the email content");
        emailService.doSend(emailModel);
        return "OK";
    }

}
