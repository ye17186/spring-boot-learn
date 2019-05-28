package com.yclouds.service.demo.modules.dp.factory.one;

/**
 * @author ye17186
 * @version 2019/5/28 12:07
 */
// 工厂类
public class OperationFactory {

    public static Operation create(String opt) {
        Operation operation;
        switch (opt) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
            default:
                throw new UnsupportedOperationException("不支持该操作");
        }
        return operation;
    }
}
