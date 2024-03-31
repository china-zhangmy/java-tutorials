package org.twinsdaddy.javatutorials.exercises.thread.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * (2)ReentrantLock是可重入锁
 * <p>
 * ReentrantLock持有一个所计数器，当已持有所的线程再次获得该锁时计数器值加1，每调用一次lock.unlock()时所计数器值减1，直到所计数器值为0，此时线程释放锁。
 */
public class ReentrantLockTest2 {

    private ReentrantLock lock = new ReentrantLock();

    public void testReentrantLock() {
        // 线程获得所
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " get lock");
            long beginTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - beginTime < 100) ;

            lock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + " get lock again");
                long beginTime2 = System.currentTimeMillis();
                while (System.currentTimeMillis() - beginTime2 < 100) ;
            } finally {
                // 线程释放锁
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " release lock");
            }
        } finally {
            // 线程释放锁
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " release lock again");
        }
    }

    public static void main(String[] args) {
        final ReentrantLockTest2 test2 = new ReentrantLockTest2();
        Thread thread = new Thread(() -> test2.testReentrantLock(), "A");
        thread.start();
    }
}
