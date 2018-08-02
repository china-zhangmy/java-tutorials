package io.socket.bio.fake_async;

import io.socket.bio.fake_async.server.ServerAcceptor;

import java.io.IOException;

public class MainServer {

    public static void main(String[] args) throws IOException {
        ServerAcceptor.start();
    }

}
