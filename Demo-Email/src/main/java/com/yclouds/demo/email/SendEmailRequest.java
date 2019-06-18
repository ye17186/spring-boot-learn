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
    private String to;

    private String subject;

    private String content;
}
