package com.yclouds.demo.dp.singleton;

/**
 * 懒汉式：线程安全，推荐
 * <p>
 * volatile关键字修饰了instance后，会禁用指令重排序，初始化完成后才会将内存地址复制给instance
 * </p>
 *
 * @author yemeng-lhq
 * @version 2019/10/11 15:13
 */
public class Singleton7 {

    private Singleton7() {
    }

    private static volatile Singleton7 instance;

    public static Singleton7 getInstance() {
        if (instance == null) { // 1
            synchronized (Singleton7.class) { // 2
                if (instance == null) { // 3
                    instance = new Singleton7(); // 4
                }
            }
        }
        return instance;
    }
}
