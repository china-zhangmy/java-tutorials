package io.socket.aio;

import io.socket.aio.client.AsyncClientHandler;

import java.util.Scanner;

public class MainClient {

    private static String DEFAULT_SERVER_HOST = "127.0.0.1";
    private static int DEFAULT_SERVER_PORT = 12345;
    private static AsyncClientHandler clientHandler;

    public static void start() {
        start(DEFAULT_SERVER_HOST, DEFAULT_SERVER_PORT);
    }

    private static void start(String host, int port) {
        if (clientHandler != null) {
            return;
        }

        clientHandler = new AsyncClientHandler(host, port);
        new Thread(clientHandler, "MainClient").start();
    }

    // 向服务器发送消息
    public static boolean sendMsg(String msg) throws Exception {
        if ("q".equals(msg)) {
            return false;
        }

        clientHandler.sendMsg(msg);
        return true;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        MainClient.start();

        System.out.println("请输入请求 信息： ");
        Scanner scanner = new Scanner(System.in);

        while (MainClient.sendMsg(scanner.nextLine())) ;
    }

}
