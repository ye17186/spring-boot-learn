package com.yclouds.demo.mybatisplus.model;

import com.yclouds.demo.mybatisplus.enums.UserTypeEnum;
import java.io.Serializable;
import lombok.Data;

/**
 * com.yclouds.demo.mybatisplus.model.UserResult
 *
 * @author ye17186
 * @version 2019/6/20 17:22
 */
@Data
public class UserResult implements Serializable {

    private static final long serialVersionUID = -853265836906126519L;
    private Long userId;

    private String name;

    private String age;

    private String email;

    private UserTypeEnum type;
}
