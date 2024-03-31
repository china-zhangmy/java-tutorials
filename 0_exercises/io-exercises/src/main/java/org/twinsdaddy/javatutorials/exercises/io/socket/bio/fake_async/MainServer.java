package org.twinsdaddy.javatutorials.exercises.io.socket.bio.fake_async;

import org.twinsdaddy.javatutorials.exercises.io.socket.bio.fake_async.server.ServerAcceptor;

import java.io.IOException;

public class MainServer {

    public static void main(String[] args) throws IOException {
        ServerAcceptor.start();
    }

}
