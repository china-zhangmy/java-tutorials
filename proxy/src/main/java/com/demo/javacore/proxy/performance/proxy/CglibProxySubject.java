package com.demo.javacore.proxy.performance.proxy;

import com.demo.javacore.proxy.performance.Subject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxySubject implements MethodInterceptor {

    public static <T extends Subject> Subject newProxyInstance(Class<T> targetClazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClazz);
        enhancer.setCallback(new CglibProxySubject());

        return (Subject) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(o, objects);
    }
}
