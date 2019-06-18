package com.yclouds.demo.email.service.impl;

import com.yclouds.demo.email.model.EmailModel;
import com.yclouds.demo.email.service.EmailService;
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * com.yclouds.demo.email.service.impl.EmailServiceImpl
 *
 * @author yemeng-lhq
 * @version 2019/6/18 21:50
 */
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    String from;

    @Override
    public void doSend(EmailModel emailModel) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setCc(emailModel.getCc());
        message.setTo(emailModel.getTo());
        message.setSubject(emailModel.getSubject());
        message.setText(emailModel.getContent());
        mailSender.send(message);

    }

    @Override
    public void doSendHtml(EmailModel emailModel) {

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(emailModel.getTo());
            helper.setCc(emailModel.getCc());
            helper.setSubject(emailModel.getSubject());
            helper.setText(emailModel.getContent(), true);

            mailSender.send(message);
        } catch (MessagingException e) {
            log.info("HTML的邮件发送异常。", e);
        }
    }

    @Override
    public void doSendWithAttachment(EmailModel emailModel, File file) {

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(emailModel.getTo());
            helper.setCc(emailModel.getCc());
            helper.setSubject(emailModel.getSubject());
            helper.setText(emailModel.getSubject(), true);
            helper.addAttachment(file.getName(), file);

            mailSender.send(message);
        } catch (MessagingException e) {
            log.info("带附件的邮件发送异常。", e);
        }

    }
}
