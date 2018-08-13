package com.demo.javacore.io.pipe;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Sender extends Thread {

    PipedOutputStream outputStream = new PipedOutputStream();

    public PipedOutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public void run() {
        String info = "Hello, Receiver";

        try {
            outputStream.write(info.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
