package com.yclouds.demo.email;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * com.yclouds.demo.email.SendEmailRequest
 *
 * @author ye1718
 * @version 2019/6/18 18:24
 */
@Setter
@Getter
public class SendEmailRequest implements Serializable {

    private static final long serialVersionUID = 865403899378271049L;

    /**
     * 收件人邮箱
     */
    private String to;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String content;
}
