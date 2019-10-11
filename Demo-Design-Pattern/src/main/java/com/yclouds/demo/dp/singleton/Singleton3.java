package com.yclouds.demo.dp.singleton;

/**
 * 懒汉式：有线程安全问题，不推荐
 * <p>
 * 当两个线程同时执行到1处时，此时instance还是null，接下来都会去执行2.
 * 先创建出来的实例会被后来的覆盖掉，造成资源浪费
 * </p>
 *
 * @author yemeng-lhq
 * @version 2019/10/11 15:04
 */
public class Singleton3 {

    private Singleton3() {
    }

    private static Singleton3 instance;

    public static Singleton3 getInstance() {
        if (instance == null) { // 1
            instance = new Singleton3(); // 2
        }
        return instance;
    }
}
