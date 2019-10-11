package com.yclouds.demo.dp.singleton;

/**
 * 懒汉式：线程安全，但是锁粒度太粗，效率不高，不推荐
 * <p>
 * JVM之前早就完成了instance的赋值，如果后来又有多个线程都去调用getInstance()，，这时仍要竞争锁
 * </p>
 *
 * @author yemeng-lhq
 * @version 2019/10/11 15:08
 */
public class Singleton4 {

    private Singleton4() {
    }

    private static Singleton4 instance;

    public static synchronized Singleton4 getInstance() { // 1
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
