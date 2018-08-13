package com.demo.javacore.io.socket.aio;

import com.demo.javacore.io.socket.aio.server.AsyncServerHandler;

public class MainServer {

    private static int DEFAULT_PORT = 12345;
    private static AsyncServerHandler serverHandler;
    public static volatile long clientCount = 0;

    public static void start() {
        start(DEFAULT_PORT);
    }

    private static synchronized void start(int port) {
        if(serverHandler != null) {
            return;
        }

        serverHandler = new AsyncServerHandler(port);
        new Thread(serverHandler, "MainServer").start();
    }

    public static void main(String[] args) {
        MainServer.start();
    }

}
