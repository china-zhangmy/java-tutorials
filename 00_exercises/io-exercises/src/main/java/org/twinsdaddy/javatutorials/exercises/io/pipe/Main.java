package org.twinsdaddy.javatutorials.exercises.io.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {

    public static void main(String[] args) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver();

        PipedOutputStream outputStream = sender.getOutputStream();
        PipedInputStream inputStream = receiver.getInputStream();

        try {
            outputStream.connect(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sender.start();
        receiver.start();
    }
}
