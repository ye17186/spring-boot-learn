package com.yclouds.demo.email.model;

import java.io.Serializable;
import lombok.Data;

/**
 * com.yclouds.demo.email.model.EmailModel
 *
 * @author ye17186
 * @version 2019/6/18 21:54
 */
@Data
public class EmailModel implements Serializable {

    private static final long serialVersionUID = 5318819387501593279L;
    /**
     * 收件人
     */
    private String to;

    /**
     * 抄送人
     */
    private String cc;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String content;
}
