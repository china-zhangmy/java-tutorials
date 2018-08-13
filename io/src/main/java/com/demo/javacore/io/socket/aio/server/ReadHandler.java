package com.demo.javacore.io.socket.aio.server;

import com.demo.javacore.thread.util.Calculator;

import javax.script.ScriptException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel socketChannel;

    public ReadHandler(AsynchronousSocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        // flip操作
        buffer.flip();

        byte[] message = new byte[buffer.remaining()];
        buffer.get(message);

        try {
            String exp = new String(message, "UTF-8");
            System.out.println("服务器收到的消息： " + exp);

            String calResult = null;
            try {
                calResult = Calculator.cal(exp);
            } catch (ScriptException e) {
                calResult = "计算错误： " + e.getMessage();
            }

            // 向客户端发送消息
            doWrite(calResult);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String result) {
        byte[] bytes = result.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.put(bytes);
        buffer.flip();

        //异步写数据 第三个参数为接收消息回调的业务Handler
        this.socketChannel.write(buffer, buffer, new WriteHandler(socketChannel));
    }

    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        try {
            this.socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
