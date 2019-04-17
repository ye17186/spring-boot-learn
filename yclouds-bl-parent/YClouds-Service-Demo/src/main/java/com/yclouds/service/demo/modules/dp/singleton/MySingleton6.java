package com.yclouds.service.demo.modules.dp.singleton;

/**
 * 静态内部类（推荐）
 * <br>实现方式与饿汉式相似，都是通过jvm的类加载机制来保证只有一个实例。
 * 与饿汉式不同的是，此方式在MySingleton6加载时，并不会为完成示例化，
 * 只有当调用getInstance()方法时，才会去加载MySingleton6Instance类，并且完成instance的实例化
 *
 * @author yemeng-lhq
 * @version 2019/4/17 14:03
 */
public class MySingleton6 {

    private MySingleton6() {
    }

    private static class MySingleton6Instance {

        private static final MySingleton6 instance = new MySingleton6();
    }

    public static MySingleton6 getInstance() {
        return MySingleton6Instance.instance;
    }
}
