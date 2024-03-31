package org.twinsdaddy.javatutorials.exercises.proxy.performance.proxy;

import org.twinsdaddy.javatutorials.exercises.proxy.performance.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxySubject implements InvocationHandler {

    private Subject target;

    private DynaProxySubject(Subject target) {
        this.target = target;
    }

    public static Subject newProxyInstance(Subject target) {
        return (Subject) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new DynaProxySubject(target));

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
