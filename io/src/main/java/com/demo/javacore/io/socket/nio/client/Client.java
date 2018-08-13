package com.demo.javacore.io.socket.nio.client;

public class Client {

    private static String DEFAULT_SERVER_HOST = "127.0.0.1";
    private static int DEFAULT_SERVER_PORT = 12345;
    private static ClientHandler clientHandler;

    public static void start() {
        start(DEFAULT_SERVER_HOST, DEFAULT_SERVER_PORT);
    }

    public static synchronized void start(String host, int port) {
        if (clientHandler != null)
            clientHandler.stop();
        clientHandler = new ClientHandler(host, port);
        new Thread(clientHandler, "Server").start();
    }

    //向服务器发送消息
    public static boolean sendMsg(String msg) throws Exception {
        if (msg.equals("q")) {
            return false;
        }

        clientHandler.sendMsg(msg);
        return true;
    }

    public static void main(String[] args) {
        start();
    }

}
