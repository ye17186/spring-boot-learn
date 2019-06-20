package com.yclouds.demo.email.service;

import com.yclouds.demo.email.model.EmailModel;
import java.io.File;

/**
 * com.yclouds.demo.email.service.EmailService
 *
 * @author ye17186
 * @version 2019/6/18 21:50
 */
public interface EmailService {


    /**
     * 发送简单邮件
     *
     * @param emailModel 邮件对象
     */
    void doSend(EmailModel emailModel);

    /**
     * 发送Html邮件
     *
     * @param emailModel 邮件对象
     */
    void doSendHtml(EmailModel emailModel);

    void doSendWithAttachment(EmailModel emailModel, File file);
}
