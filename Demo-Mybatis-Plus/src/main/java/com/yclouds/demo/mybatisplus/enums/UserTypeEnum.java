package com.yclouds.demo.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * com.yclouds.demo.mybatisplus.domain.enums.UserTypeEnum
 *
 * @author ye17186
 * @version 2019/6/20 15:16
 */
@Getter
public enum  UserTypeEnum {

    aa("A","管理员"),

    bb("N","普通用户");

    UserTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    @EnumValue
    private String type;

    private String desc;
}
