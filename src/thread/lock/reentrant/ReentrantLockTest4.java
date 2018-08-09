package thread.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 在通过lock()获取锁的过程中是无法中断的， 即Thread.interrupt()方法将不会中断当前线程；但是ReentrantLock提供了tryLock()、
 * tryLock(long timeout, TimeUnit unit)、lock.lockInterruptibly()
 * <p>
 * tryLock() 方法试图申请一个锁，在成功获得锁后返回true；否则，立即返回false,而且线程可以立即离开去做其他的事情。
 * tryLock(long timeout, TimeUnit unit) 是一个具有超时参数的尝试申请锁的方法，阻塞时间不会超过给定的值；如果成功则返回true
 * lockInterruptibly() 获得锁，但是会不确定地发生阻塞。如果线程被中断，抛出一个InterruptedException异常。
 */
public class ReentrantLockTest4 {

    private ReentrantLock lock = new ReentrantLock();

    public void tryLockTest() {
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < 100) ;

        // 当前线程尝试获得锁，如果获得锁返回true，否则返回false
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + " get lock");
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " release lock");
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " can not get lock");
        }
    }

    public void lockTest() {
        // 当前线程在锁可用时直接获得锁，锁不可用时阻塞当前线程
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " get lock");
            long beginTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - beginTime < 1000) ;
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " release lock");
        }
    }

    public static void main(String[] args) {
        final ReentrantLockTest4 test = new ReentrantLockTest4();

        Thread tryLockThread = new Thread(() -> test.tryLockTest(), "tryLock_thread");
        Thread lockThread = new Thread(() -> test.lockTest(), "lock_thread");

        tryLockThread.start();
        lockThread.start();
    }
}
