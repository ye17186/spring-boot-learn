package com.yclouds.demo.dp.singleton;

/**
 * 优化版饿汉式：利用JVM的类加载机制，实现单例。推荐
 * <p>
 * 只有调用了getInstance()方法，才会触发Singleton2Instance类的加载，也就是说到使用时才会创建Singleton2实例
 * </p>
 *
 * @author yemeng-lhq
 * @version 2019/10/11 11:09
 */
public class Singleton2 {

    private Singleton2() {
    }

    private static class Singleton2Instance {

        private static final Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return Singleton2Instance.instance;
    }
}
