package com.demo.javacore.thread.interruption;

/**
 * 当线程调用Thread.sleep()、Thread.join()、object.wait()再或者调用阻塞的i/o操作方法时，都会使得当前线程进入阻塞状态。
 * 在线程处于阻塞状态，如果调用interrupt()方法设置线程中断标志位时，此时处于阻塞状态的线程将会抛出一个异常，并且会清
 * 除线程中断标志位(设置为false)，这样一来线程就能退出阻塞状态。
 */
public class InterruptBlockedThread extends Thread {

    @Override
    public void run() {
        // 这里调用的是非清除中断标志位的isInterrupted方法
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " is running");

            try {
                System.out.println(Thread.currentThread().getName() + " Thread.sleep begin");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " Thread.sleep end");
            } catch (InterruptedException e) {
                // 由于调用sleep()方法清除状态标志位 所以这里需要再次重置中断标志位 否则线程会继续运行下去
                Thread.currentThread().interrupt();
            }
        }

        if (Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " is interrupted");
        }
    }

    public static void main(String[] args) {
        InterruptBlockedThread thread = new InterruptBlockedThread();
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 设置线程的中断标志位
        thread.interrupt();
    }
}
