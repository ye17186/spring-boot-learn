package com.yclouds.demo.mybatisplus.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.lang.ref.PhantomReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * com.yclouds.demo.mybatisplus.model.MyPage
 *
 * @author ye17186
 * @version 2019/6/20 16:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MyPage<T> extends Page<T> {

    private static final long serialVersionUID = 8786763694697072435L;

    /**
     * 年龄大于等于
     */
    private Integer geAge;

    private Boolean deleted;

    public MyPage(long current, long size) {
        super(current, size);
    }

}
