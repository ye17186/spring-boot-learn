package com.yclouds.demo.dp.singleton;

/**
 * 饿汉式：利用JVM的类加载机制，实现单例。此方式可能会造成资源浪费，不推荐。
 * <p>
 * 1、如果只有getInstance()方法，是不会造成资源浪费的，只有调用了这个方法，才会触发Singleton1的加载，然后才会初始化
 * 2、如果Singleton1类中还有其他静态方法，当调用这个方法时，也会触发类加载并且初始化instance。如果全局都没有使用instance的话，这就是一种浪费
 * </p>
 *
 * @author yemeng-lhq
 * @version 2019/10/11 11:09
 */
public class Singleton1 {

    private Singleton1() {
    }

    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }
}
