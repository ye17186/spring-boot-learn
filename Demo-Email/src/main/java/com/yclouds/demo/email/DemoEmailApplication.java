package com.yclouds.demo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/email")
public class DemoEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEmailApplication.class, args);
    }

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    String from;

    @PostMapping("/send")
    public String sendEmail(SendEmailRequest request) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(from);
        email.setTo(request.getTo());
        email.setSubject(request.getSubject());
        email.setText(request.getContent());
        mailSender.send(email);
        return "OK";
    }

}
