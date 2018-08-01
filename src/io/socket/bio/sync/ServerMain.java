package io.socket.bio.sync;

import io.socket.bio.sync.server.ServerAcceptor;

import java.io.IOException;

public class ServerMain {

    public static void main(String[] args) throws IOException {
        ServerAcceptor.start();
    }

}
