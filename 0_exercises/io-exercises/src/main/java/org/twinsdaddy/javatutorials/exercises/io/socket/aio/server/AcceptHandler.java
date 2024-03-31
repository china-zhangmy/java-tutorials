package org.twinsdaddy.javatutorials.exercises.io.socket.aio.server;

import org.twinsdaddy.javatutorials.exercises.io.socket.aio.MainServer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel socketChannel, AsyncServerHandler serverHandler) {
        // 继续接受其他客户端的请求
        MainServer.clientCount++;
        System.out.println("连接的客户端数： " + MainServer.clientCount);

        serverHandler.serverSocketChannel.accept(serverHandler, this);

        // 创建新的Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 异步读  第三个参数为接收消息回调的业务Handler
        socketChannel.read(buffer, buffer, new ReadHandler(socketChannel));
    }

    @Override
    public void failed(Throwable exc, AsyncServerHandler serverHandler) {
        exc.printStackTrace();
        serverHandler.latch.countDown();
    }
}
