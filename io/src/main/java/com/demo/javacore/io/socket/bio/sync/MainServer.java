package com.demo.javacore.io.socket.bio.sync;

import com.demo.javacore.io.socket.bio.sync.server.ServerAcceptor;

import java.io.IOException;

public class MainServer {

    public static void main(String[] args) throws IOException {
        ServerAcceptor.start();
    }

}
