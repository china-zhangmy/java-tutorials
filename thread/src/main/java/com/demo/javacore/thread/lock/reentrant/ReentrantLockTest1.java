package com.demo.javacore.thread.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * (1) ReentrantLock锁的使用结构
 * <p>
 * 解锁操作括在finally字句之内是至关重要的，如果受保护的代码抛出异常，锁可以得到释放，这样可以避免死锁的发生
 * <p>
 * 注： 在无参获取锁的过程中是无法中断的， 即Thread.interrupt()方法将不会中断当前线程
 */
public class ReentrantLockTest1 {

    private int num = 10;
    private ReentrantLock lock = new ReentrantLock();

    public void writeNumMethod() {
        lock.lock();

        try {
            // 受保护的代码
            int index = 10;

            while (index > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + num);

                num = -10;

                long beginTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - beginTime < 10) ;

                num = +10;
                System.out.println(Thread.currentThread().getName() + " : " + num);
                index--;
            }
        } finally {
            // 可以保证发生异常时，锁可以得到释放，避免死锁的发生
            lock.unlock();
        }
    }

    public void readNumMethod() {
        lock.lock();

        try {
            int index = 10;

            // 受保护的代码
            while (index > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + num);
                index--;
            }
        } finally {
            // 可以保证发生异常时锁可以得到释放，避免死锁的发生
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReentrantLockTest1 myLockTest = new ReentrantLockTest1();

        Thread t1 = new Thread(() -> myLockTest.writeNumMethod(), "A");
        Thread t2 = new Thread(() -> myLockTest.readNumMethod(), "B");

        t1.start();
        t2.start();
    }
}
