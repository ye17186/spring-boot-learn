package com.yclouds.demo.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.yclouds.demo.mybatisplus.enums.UserTypeEnum;
import java.io.Serializable;
import lombok.Data;

/**
 * com.yclouds.demo.mybatisplus.domain.UserEntity
 *
 * @author ye17186
 * @version 2019/6/20 10:43
 */
@Data
@TableName("tb_user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 4532905185981001360L;

    /**
     * 主键ID，自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户邮件
     */
    private String email;

    /**
     * 用户类型
     */
    private UserTypeEnum type;

    /**
     * 数据版本
     */
    @Version
    private Long version;

    /**
     * 是否逻辑删除
     */
    @TableLogic
    private Boolean deleted;

}
