package io.socket.aio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncServerHandler implements Runnable {
    public CountDownLatch latch;
    public AsynchronousServerSocketChannel serverSocketChannel;

    public AsyncServerHandler(int port) {
        try {
            // 创建服务端通道
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            // 绑定端口
            serverSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("服务器已启动， 端口号： " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // CountDownLatch初始化
        // 作用：在完成一组正在执行的操作之前，允许当前的现场一直阻塞
        // 此处，让现场在此阻塞，防止服务端执行完成后退出; 也可以使用while(true)+sleep
        // 生产环境就不需要担心这个问题，因为服务端是不会退出的
        latch = new CountDownLatch(1);
        // 用于接收客户端的连接
        serverSocketChannel.accept(this, new AcceptHandler());

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
