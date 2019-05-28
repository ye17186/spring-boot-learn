package com.yclouds.service.demo.modules.dp.singleton;

/**
 * 饿汉式（静态常量）单例
 * <br>优点：写法简单，在类装载时就完成实例化，有效避免了线程同步问题
 * <br>确定：类加载时完成实例化，开辟了内存空间，如果该示例未被使用过，则会造成内存的浪费
 *
 * @author ye17186
 * @version 2019/4/17 13:41
 */
public class MySingleton1 {

    private static MySingleton1 instance = new MySingleton1();

    public static MySingleton1 getInstance() {
        return instance;
    }

    private MySingleton1() {
    }
}
