package com.yclouds.service.demo.modules.dp.singleton;

/**
 * 双重检查（推荐）
 *
 * <br>既实现了懒加载，通过同步及双重检查，实现了线程安全，效率较高
 *
 * @author yemeng-lhq
 * @version 2019/4/17 13:58
 */
public class MySingleton5 {

    private static volatile MySingleton5 instance;

    private MySingleton5() {
    }

    public static MySingleton5 getInstance() {

        if (instance == null) {
            synchronized (MySingleton5.class) {
                if (instance == null) {
                    instance = new MySingleton5();
                }
            }
        }
        return instance;
    }
}
