package com.demo.javacore.proxy.performance;

public class RealSubject implements Subject {

    public int test(int i) {
        return i + 1;
    }

}
