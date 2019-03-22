package com.yclouds.common.core.response;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * @author ye17186
 * @version 2019/3/14 18:18
 */
@Data
public class ApiPage<T> implements Serializable {

    private static final long serialVersionUID = -4221192540046646043L;

    /**
     * 数据总数
     */
    private Long total;
    /**
     * 页码总数
     */
    private Integer pages;
    /**
     * 页码
     */
    private Integer pageNo;
    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 数据
     */
    private List<T> items;
}
