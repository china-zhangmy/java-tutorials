package org.twinsdaddy.javatutorials.exercises.io.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

public class Receiver extends Thread {
    PipedInputStream inputStream = new PipedInputStream();

    public PipedInputStream getInputStream() {
        return inputStream;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];

        try {
            int len = inputStream.read(buffer);
            System.out.println("Receive message from sender: " + new String(buffer, 0, len));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
