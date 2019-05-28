package com.yclouds.service.demo.modules.dp.factory.one;

/**
 * @author ye17186
 * @version 2019/5/28 11:54
 */
public class OperationDiv extends Operation {

    @Override
    protected double getResult() {

        if (getValue2() == 0) {
            throw new IllegalArgumentException("除数不能为零");
        }
        return getValue1() / getValue2();
    }
}