package com.yclouds.demo.dp.singleton;

/**
 * 懒汉式：线程不安全
 * <p>
 * 如果两个线程都执行到1处，线程A获得了锁，完成了instance赋值，然后释放锁。这时线程B获得锁后会接着执行2
 * </p>
 *
 * @author yemeng-lhq
 * @version 2019/10/11 15:13
 */
public class Singleton5 {

    private Singleton5() {
    }

    private static Singleton5 instance;

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) { // 1
                instance = new Singleton5(); // 2
            }
        }
        return instance;
    }
}
