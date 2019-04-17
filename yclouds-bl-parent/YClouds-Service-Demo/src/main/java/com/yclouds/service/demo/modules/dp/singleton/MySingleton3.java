package com.yclouds.service.demo.modules.dp.singleton;

/**
 * 懒汉式单例（线程不安全，不推荐）
 * <br>优点：实现了懒加载，在使用的时候才去实例化
 * <br>确定：线程不安全，假设2个线程同时调用getInstance()，并且都走到if(instance == null)，此情况下，两个线程都会去实例化
 *
 * @author yemeng-lhq
 * @version 2019/4/17 13:49
 */
public class MySingleton3 {

    private static MySingleton3 instance;

    private MySingleton3() {
    }

    public static MySingleton3 getInstance() {
        if (instance == null) {
            instance = new MySingleton3();
        }
        return instance;
    }
}
