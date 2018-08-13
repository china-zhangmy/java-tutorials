package com.demo.javacore.thread.daemon;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 运行结果：文件daemon.txt中没有"daemon"字符串。 原因：守护线程在启动后，用户线程即刻结束，虚拟机亦自动退出。
 * 但是如果把thread.setDaemon(true)注释掉，文件daemon.txt是可以被写入daemon字符串的
 */
public class DaemonThread implements Runnable {

    @Override
    public void run() {
        try {

            Thread.sleep(1000);//守护线程阻塞1秒后运行

            FileOutputStream os = new FileOutputStream("daemon.txt", true);
            os.write("daemon".getBytes());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException

    {
        Thread thread = new Thread(new DaemonThread());

        //设置守护线程
        thread.setDaemon(true);

        //开始执行分进程
        thread.start();
    }
}
