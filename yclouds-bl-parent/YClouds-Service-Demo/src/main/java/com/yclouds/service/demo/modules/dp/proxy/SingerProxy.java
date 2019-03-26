package com.yclouds.service.demo.modules.dp.proxy;

/**
 * 经纪人类，代理自己的歌手
 *
 * @author ye17186
 * @version 2019/3/25 17:18
 */
public class SingerProxy implements Singer{

    private Singer singer;

    // 代理自己的歌手
    public SingerProxy(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void sing() {
        System.out.println("我是经纪人，我去安排歌手唱歌。");
        singer.sing();
        System.out.println("唱完了，请付款。");
    }
}
