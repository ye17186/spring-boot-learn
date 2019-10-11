package com.yclouds.demo.dp.singleton;

/**
 * 懒汉式：线程安全，但是也有风险，不推荐
 * <p>
 * 线程A执行到4处，执行new Singleton6()。JVM先分配了内存，然后将instance的引用指向这块内存，但是这个类还没有完成初始化
 * 此时，如果有一个线程B执行到1处，发现instance已经不为null了（因为线程A已经将instance执行一个地址了，只是没有完成初始化），
 * 如果线程B现在就是使用的instance的话，就会报错了（因为此时还没有完成初始化）
 * </p>
 *
 * @author yemeng-lhq
 * @version 2019/10/11 15:13
 */
public class Singleton6 {

    private Singleton6() {
    }

    private static Singleton6 instance;

    public static Singleton6 getInstance() {
        if (instance == null) { // 1
            synchronized (Singleton6.class) { // 2
                if(instance == null) { // 3
                    instance = new Singleton6(); // 4
                }
            }
        }
        return instance;
    }
}
