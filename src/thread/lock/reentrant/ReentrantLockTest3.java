package thread.lock.reentrant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock的条件对象
 * <p>
 * 通常，线程进入临界区，却发现在某一条件满足之后才能执行，条件对象就是用来管理那些已经获得了锁，但是却不能做有用工作的线程。
 * 一个锁对象可以有一个或多个相关的条件对象，我们可用lock.newCondition()方法获得一个条件对象。
 */
public class ReentrantLockTest3 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private List<Integer> listBuffer = new ArrayList<>();

    private volatile boolean runFlag = true;

    public boolean isRunFlag() {
        return runFlag;
    }

    public void setRunFlag(boolean runFlag) {
        this.runFlag = runFlag;
    }

    /**
     * 生产者 生产数据
     */
    public void produce() {
        int i = 0;

        while (runFlag) {
            lock.lock();

            try {
                // 生产者检查容器中是否有数据，如果容器中有数据则生产者等待
                // 如果容器中没有数据则生产数据放入容器中并通知消费者
                if (listBuffer.size() > 0) {
                    try {
                        // 调用await()方法，生产者线程阻塞并释放锁，之后进入该条件的等待集中
                        // 直到消费者调用signalAll()方法之后，生产者线程解除阻塞并重新竞争锁
                        // 生产者线程获得锁之后，重新开始从被阻塞的地方继续执行程序
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Integer m;
                    listBuffer.add(m = i++);
                    System.out.println(Thread.currentThread().getName() + " add Integer " + m);
                    // 生产者线程调用signalAll()方法，通知消费者线程容器中有数据
                    condition.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 消费者 读取数据
     */
    public void consume() {
        while (runFlag) {
            lock.lock();

            try {
                // 消费者检查容器中是否有数据，如果没有数据消费者等待
                // 如果容器中有数据则读取数据，读完之后通知生产者
                if (listBuffer.size() == 0) {
                    try {
                        // 同生产者线程一样，消费者线程调用await()方法阻塞并进入该条件等待集中
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " get Integer " + listBuffer.remove(0));
                    long beginTime = System.currentTimeMillis();
                    while (System.currentTimeMillis() - beginTime < 100) ;
                    // 消费者线程调用signalAll()方法，通知生产者生产数据
                    condition.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest3 test = new ReentrantLockTest3();

        Thread producer = new Thread(() -> test.produce(), "A");
        Thread consumer = new Thread(() -> test.consume(), "B");

        producer.start();
        consumer.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.setRunFlag(false);
    }
}
