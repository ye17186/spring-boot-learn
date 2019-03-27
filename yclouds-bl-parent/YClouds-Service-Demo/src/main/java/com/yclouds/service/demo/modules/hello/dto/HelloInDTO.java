package com.yclouds.service.demo.modules.hello.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * @author ye17186
 * @version 2019/3/26 16:36
 */
@Data
public class HelloInDTO implements Serializable {

    private static final long serialVersionUID = -5901714862103467412L;

    private String title;

    private String password;

    private HelloInDTO sub;
}