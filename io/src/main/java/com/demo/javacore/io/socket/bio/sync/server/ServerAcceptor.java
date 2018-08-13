package com.demo.javacore.io.socket.bio.sync.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class ServerAcceptor {

    //默认的端口号
    private static int DEFAULT_PORT = 12345;
    //单例的ServerSocket
    private static ServerSocket serverSocket;

    //根据传入参数设置监听端口，如果没有参数调用以下方法并使用默认值
    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }

    private synchronized static void start(int port) throws IOException {
        if(serverSocket != null) {
            return;
        }

        try {
            //通过构造函数创建ServerSocket
            //如果端口合法且空闲，服务端就监听成功
            serverSocket = new ServerSocket(port);
            System.out.println("服务器已启动, 端口号： " + port);

            Socket socket;
            //通过无线循环监听客户端连接
            while (true) {
                //如果没有客户端接入，将阻塞在accept操作上。
                socket = serverSocket.accept();
                //当有新的客户端接入时，会创建一个新的线程处理这条Socket链路
                System.out.println("新的客户端接入, 启动新的" + socket + ", instance: " + socket.hashCode());
                new Thread(new ServerHandler(socket)).start();
            }
        } finally {
            if(serverSocket != null) {
                serverSocket.close();
                System.out.println("服务器已关闭！");
                serverSocket = null;
            }
        }




    }

}
