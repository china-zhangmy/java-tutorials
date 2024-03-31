package org.twinsdaddy.javatutorials.exercises.io.socket.aio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class AsyncClientHandler implements Runnable, CompletionHandler<Void, AsyncClientHandler> {

    private AsynchronousSocketChannel socketChannel;
    private String host;
    private int port;
    private CountDownLatch latch;

    public AsyncClientHandler(String host, int port) {
        this.host = host;
        this.port = port;

        try {
            // 创建异步的客户端通道
            socketChannel = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // 创建CountDownLatch等待
        latch = new CountDownLatch(1);
        //发起异步连接操作，回调参数就是这个类本身，如果连接成功会回调completed方法
        socketChannel.connect(new InetSocketAddress(host, port), this, this);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //连接服务器成功, 意味着TCP三次握手完成
    @Override
    public void completed(Void result, AsyncClientHandler clientHandler) {
        System.out.println("客户端成功连接到服务器...");
    }

    //连接服务器失败
    @Override
    public void failed(Throwable exc, AsyncClientHandler clientHandler) {
        System.err.println("连接服务器失败...");
        exc.printStackTrace();
        try {
            socketChannel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务器发送消息
    public void sendMsg(String msg) {
        byte[] bytes = msg.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.put(bytes);
        buffer.flip();

        //异步写
        socketChannel.write(buffer, buffer, new WriteHandler(socketChannel, latch));
    }
}
