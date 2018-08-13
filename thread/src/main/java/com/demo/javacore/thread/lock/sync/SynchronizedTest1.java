package com.demo.javacore.thread.lock.sync;

/**
 * Java 中每一个对象都有一个内部锁，每一个类都有一个类锁，如果一个方法用synchronized关键字声明，那么该方法称为“同步方法”，
 * 那么进入到该方法的线程将获得这个对象的锁，在该线程调用“同步方法”结束之前，其他试图调用该“同步方法”的线程将会阻塞。
 * <p>
 * (1)synchronized关键字加锁
 */
public class SynchronizedTest1 {

    // 使用synchronized关键字修饰的同步方法
    public synchronized void printNum() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        final SynchronizedTest1 test = new SynchronizedTest1();

        Thread t1 = new Thread(() -> test.printNum(), "A");
        Thread t2 = new Thread(() -> test.printNum(), "B");

        t1.start();
        t2.start();
    }

}
