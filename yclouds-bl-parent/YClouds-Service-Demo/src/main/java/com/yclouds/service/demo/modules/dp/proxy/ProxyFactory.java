package com.yclouds.service.demo.modules.dp.proxy;

import java.lang.reflect.Proxy;

/**
 * @author ye17186
 * @version 2019/3/25 18:13
 */
public class ProxyFactory {

    // 目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
            target.getClass().getInterfaces(), (proxy, method, args) -> {
                System.out.println("动态代理：我是经纪人，我去安排歌手唱歌。");
                Object ret = method.invoke(target, args);
                System.out.println("动态代理：唱完了，请付款。");
                return ret;
            });
    }
}
