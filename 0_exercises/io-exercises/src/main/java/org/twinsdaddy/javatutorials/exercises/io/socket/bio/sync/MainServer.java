package org.twinsdaddy.javatutorials.exercises.io.socket.bio.sync;

import org.twinsdaddy.javatutorials.exercises.io.socket.bio.sync.server.ServerAcceptor;

import java.io.IOException;

public class MainServer {

    public static void main(String[] args) throws IOException {
        ServerAcceptor.start();
    }

}
