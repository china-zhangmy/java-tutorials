package com.demo.javacore.proxy.static_vs_dyna.dyna_proxy;

import com.demo.javacore.proxy.static_vs_dyna.Subject;

public class Client {

    public static void main(String[] args) {
        Subject proxy = DynaProxyFactory.getInstance();
        proxy.dealTask("DBQueryTask");
    }

}
