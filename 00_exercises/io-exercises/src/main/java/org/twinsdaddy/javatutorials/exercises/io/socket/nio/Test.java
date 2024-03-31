package org.twinsdaddy.javatutorials.exercises.io.socket.nio;

import org.twinsdaddy.javatutorials.exercises.io.socket.nio.client.Client;
import org.twinsdaddy.javatutorials.exercises.io.socket.nio.server.Server;

import java.util.Scanner;

public class Test {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        //运行服务器
        Server.start();

        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);

        //运行客户端
        Client.start();
        while (true) {
            System.out.print("客户端发送消息： ");
            if (!Client.sendMsg(new Scanner(System.in).nextLine())) {
                break;
            }
        }
    }

}
