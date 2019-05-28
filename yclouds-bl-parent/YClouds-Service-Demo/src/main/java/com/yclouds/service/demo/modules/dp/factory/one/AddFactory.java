package com.yclouds.service.demo.modules.dp.factory.one;

/**
 * @author ye17186
 * @version 2019/5/28 13:47
 */
public class AddFactory implements IFactory {

    @Override
    public Operation create() {
        return new OperationAdd();
    }
}
