package org.twinsdaddy.javatutorials.exercises.thread.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest5 {

    private ReentrantLock lock = new ReentrantLock();

    public void tryLockInterruptTest() {
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < 100) ;

        try {
            if (lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " get lock");
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        }
    }

    public void lockTest() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " get lock");
            long beginTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - beginTime < 1000) ;
        } finally {
            System.out.println(Thread.currentThread().getName() + " release lock");
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest5 test = new ReentrantLockTest5();

        Thread tryLockInterruptThread = new Thread(() -> test.tryLockInterruptTest(), "tryLockInterrupt_thread");
        Thread lockThread = new Thread(() -> test.lockTest(), "lock_thread");

        tryLockInterruptThread.start();
        lockThread.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tryLockInterruptThread.interrupt();
    }
}
