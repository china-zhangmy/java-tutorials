package thread.interruption;

/**
 * 有一种情况是线程不能被中断的，就是调用synchronized关键字和reentrantLock.lock()获取锁的过程。
 * <p>
 * 但是如果调用带超时的tryLock方法reentrantLock.tryLock(long timeout, TimeUnit unit)，那么如果线程在等待时被中断，
 * 将抛出一个InterruptedException异常，这是一个非常有用的特性，因为它允许程序打破死锁。
 * 你也可以调用reentrantLock.lockInterruptibly()方法，它就相当于一个超时设为无限的tryLock方法。
 */
public class NonInterruptibleThread {

    public void deathLock(Object lock1, Object lock2) {
        try {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " is running");
                // 让另外一个线程获得另一个锁
                Thread.sleep(1000);
                // 造成死锁
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " is still running");
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interrupted");
        }
    }

    public static void main(String[] args) {
        NonInterruptibleThread thread = new NonInterruptibleThread();

        Object lock1 = new Object();
        Object lock2 = new Object();

        // 线程交叉死锁
        Thread t1 = new Thread(() -> thread.deathLock(lock1, lock2), "Thread 1");
        Thread t2 = new Thread(() -> thread.deathLock(lock2, lock1), "Thread 2");

        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 中断线程t1、t2
        t1.interrupt();
        t2.interrupt();
    }
}
