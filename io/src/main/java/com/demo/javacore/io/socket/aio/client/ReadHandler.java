package com.demo.javacore.io.socket.aio.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel socketChannel;
    private CountDownLatch latch;

    public ReadHandler(AsynchronousSocketChannel socketChannel, CountDownLatch latch) {
        this.socketChannel = socketChannel;
        this.latch = latch;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        buffer.flip();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);

        try {
            String body = new String(bytes, "UTF-8");
            System.out.println("客户端收到结果: " + body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        System.err.println("数据读取失败...");
        try {
            socketChannel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
