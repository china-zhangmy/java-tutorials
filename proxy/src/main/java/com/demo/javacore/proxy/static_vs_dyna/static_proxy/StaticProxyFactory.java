package com.demo.javacore.proxy.static_vs_dyna.static_proxy;

import com.demo.javacore.proxy.static_vs_dyna.RealSubject;
import com.demo.javacore.proxy.static_vs_dyna.Subject;

public class StaticProxyFactory {

    //客户类调用此工厂方法获得代理对象。
    //对客户类来说，其并不知道返回的是代理类对象还是委托类对象。
    public static Subject getInstance() {
        return new StaticProxySubject(new RealSubject());
    }

}
