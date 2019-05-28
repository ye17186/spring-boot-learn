package com.yclouds.service.demo.modules.dp.singleton;

/**
 * 懒汉式单例（线程安全，同步阻塞，不推荐）
 *
 * <br>优点：实现了懒加载，在使用的时候才去实例化
 * <br>缺点：getInstance()方法时同步的，虽然避免的线程安全问题，但是同步方法会阻塞，效率太低
 *
 * @author ye17186
 * @version 2019/4/17 13:54
 */
public class MySingleton4 {

    private static MySingleton4 instance;

    private MySingleton4() {
    }

    public static synchronized MySingleton4 getInstance() {
        if (instance == null) {
            instance = new MySingleton4();
        }
        return instance;
    }
}
