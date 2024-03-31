package org.twinsdaddy.javatutorials.exercises.proxy.static_vs_dyna.dyna_proxy;

import org.twinsdaddy.javatutorials.exercises.proxy.static_vs_dyna.Subject;

public class Client {

    public static void main(String[] args) {
        Subject proxy = DynaProxyFactory.getInstance();
        proxy.dealTask("DBQueryTask");
    }

}
