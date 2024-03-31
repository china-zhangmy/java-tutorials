package org.twinsdaddy.javatutorials.exercises.proxy.performance.proxy;

import org.twinsdaddy.javatutorials.exercises.proxy.performance.Subject;

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
