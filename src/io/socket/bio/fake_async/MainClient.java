package io.socket.bio.fake_async;

import io.socket.bio.fake_async.client.ClientHandler;

import java.util.Random;

public class MainClient {

    public static void main(String[] args) {
        char operators[] = {'+', '-', '*', '/'};
        Random random = new Random(System.currentTimeMillis());

        while (true) {
            String exp = String.valueOf(random.nextInt(10))
                    + String.valueOf(operators[random.nextInt(4)])
                    + String.valueOf(random.nextInt(10));

            ClientHandler.send(exp);

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
