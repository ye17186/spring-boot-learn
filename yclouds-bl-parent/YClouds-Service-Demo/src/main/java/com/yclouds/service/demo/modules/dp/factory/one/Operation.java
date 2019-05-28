package com.yclouds.service.demo.modules.dp.factory.one;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ye17186
 * @version 2019/5/28 11:52
 */
@Setter
@Getter
public abstract class Operation {

    private double value1;

    private double value2;

    protected abstract double getResult();
}
