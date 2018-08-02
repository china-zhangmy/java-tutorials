package io.socket.bio.fake_async.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler {

    //默认的服务器端口号
    private static final String DEFAULT_SERVER_IP = "127.0.0.1";
    private static final int DEFAULT_SERVER_PORT = 12345;

    public static void send(String exp) {
        send(DEFAULT_SERVER_IP, DEFAULT_SERVER_PORT, exp);
    }

    public static void send(String ip, int port, String exp) {
        System.out.println("算术表达式为： " + exp);

        try (Socket socket = new Socket(ip, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            System.out.println("新的客户端Socket被创建： " + socket);
            out.println(exp);
            System.out.println("__结果为： " + in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
