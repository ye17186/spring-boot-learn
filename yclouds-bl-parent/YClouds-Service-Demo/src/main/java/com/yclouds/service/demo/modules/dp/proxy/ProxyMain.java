package com.yclouds.service.demo.modules.dp.proxy;

/**
 * @author ye17186
 * @version 2019/3/25 17:21
 */
public class ProxyMain {

    public static void main(String[] args) {

        // 目标对象
        Singer singer = new SingerImpl();

        // 代理对象
        Singer proxy = (Singer) new ProxyFactory2(singer).getProxyInstance();

        proxy.sing();
    }
}
