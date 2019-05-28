package com.yclouds.service.demo.modules.dp.factory.one;

/**
 * @author ye17186
 * @version 2019/5/28 11:54
 */
public class OperationMul extends Operation {

    @Override
    protected double getResult() {
        return getValue1() * getValue2();
    }
}
