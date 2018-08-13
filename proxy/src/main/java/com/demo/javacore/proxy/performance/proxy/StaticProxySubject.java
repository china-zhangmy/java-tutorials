package com.demo.javacore.proxy.performance.proxy;

import com.demo.javacore.proxy.performance.Subject;

public class StaticProxySubject implements Subject {

    private Subject target;

    public StaticProxySubject(Subject target) {
        this.target = target;
    }

    @Override
    public int test(int i) {
        return target.test(i);
    }
}
