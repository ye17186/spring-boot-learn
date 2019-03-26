package com.yclouds.service.demo.modules.dp.proxy;

/**
 * 目标对象，歌手实现类，提供具体的唱歌服务
 *
 * @author ye17186
 * @version 2019/3/25 17:15
 */
public class SingerImpl implements Singer {

    @Override
    public void sing() {
        System.out.println("i am singing.");
    }

}
