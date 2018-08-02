package io.socket.aio.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class WriteHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel socketChannel;

    public WriteHandler(AsynchronousSocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void completed(Integer result, ByteBuffer writeBuffer) {
        // 如果没有发送完，就继续发送直到完成
        if (writeBuffer.hasRemaining()) {
            socketChannel.write(writeBuffer, writeBuffer, this);
        } else {
            // 创建新的Buffer
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            // 异步读  第三个参数为接收消息回调的业务Handler
            socketChannel.read(readBuffer, readBuffer, new ReadHandler(socketChannel));
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        exc.printStackTrace();
        try {
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
