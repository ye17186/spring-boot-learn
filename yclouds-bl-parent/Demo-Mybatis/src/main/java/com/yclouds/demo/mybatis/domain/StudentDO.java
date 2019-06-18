package com.yclouds.demo.mybatis.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * com.yclouds.demo.mybatis.domain.StudentDO
 *
 * @author yemeng-lhq
 * @version 2019/6/18 16:55
 */
@Data
public class StudentDO implements Serializable {

    private static final long serialVersionUID = 2772129309279897726L;
    private Long id;

    private String name;

    private Integer age;

    private Date birthday;

}
