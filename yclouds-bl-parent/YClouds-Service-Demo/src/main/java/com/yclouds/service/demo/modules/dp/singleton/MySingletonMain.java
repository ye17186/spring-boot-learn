package com.yclouds.service.demo.modules.dp.singleton;

/**
 * @author ye17186
 * @version 2019/4/17 14:21
 */
public class MySingletonMain {

    public static void main(String[] args) {
        System.out.println(MySingleton1.getInstance() == MySingleton1.getInstance());
        System.out.println(MySingleton2.getInstance() == MySingleton2.getInstance());
        System.out.println(MySingleton3.getInstance() == MySingleton3.getInstance());
        System.out.println(MySingleton4.getInstance() == MySingleton4.getInstance());
        System.out.println(MySingleton5.getInstance() == MySingleton5.getInstance());
        System.out.println(MySingleton6.getInstance() == MySingleton6.getInstance());
        System.out.println(MySingleton7.RED == MySingleton7.RED);
    }
}
