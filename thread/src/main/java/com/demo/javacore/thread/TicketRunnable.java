package com.demo.javacore.thread;

public class TicketRunnable implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        while (true) {
            // 添加同步块
            synchronized (this) {
                if (this.ticket <= 0) {
                    break;
                }

                try {
                    // 通过睡眠线程来模拟出最后一张票的抢票场景
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "买票 ----> " + this.ticket--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] arg) {
        Runnable r = new TicketRunnable();

        new Thread(r, "线程1").start();
        new Thread(r, "线程2").start();
    }
}
