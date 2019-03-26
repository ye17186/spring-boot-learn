package com.yclouds.service.demo.modules.dp.proxy;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author ye17186
 * @version 2019/3/25 18:13
 */
public class ProxyFactory2 implements MethodInterceptor {

    /**
     * 目标对象
     */
    private Object target;

    public ProxyFactory2(Object target) {
        this.target = target;
    }

    /**
     * 生成代理对象
     */
    public Object getProxyInstance() {

        // 工具类
        Enhancer en = new Enhancer();
        // 设置父类
        en.setSuperclass(target.getClass());
        // 设置回调
        en.setCallback(this);
        // 创建子类，即代理对象
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
        throws Throwable {
        System.out.println("Cglib代理：我是经纪人，我去安排歌手唱歌。");
        Object ret = method.invoke(target, args);
        System.out.println("Cglib代理：唱完了，请付款。");
        return ret;
    }
}
