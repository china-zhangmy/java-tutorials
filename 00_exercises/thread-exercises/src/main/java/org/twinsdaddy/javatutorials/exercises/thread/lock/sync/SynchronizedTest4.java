package org.twinsdaddy.javatutorials.exercises.thread.lock.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizedTest4 {

    Object object = new Object();
    private List<Integer> list = new ArrayList<>();
    private Random random = new Random();

    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * 使用object对象的锁，以及该锁的条件对象
     */
    public void produce() {
        while (flag) {
            synchronized (object) {
                if (list.size() > 0) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    int num = random.nextInt(1000);
                    list.add(num);
                    System.out.println("生产者生产数据： " + num);
                    object.notifyAll();
                }
            }
        }
    }

    /**
     * 消费者线程每次消费一个数据
     */
    public void consume() {
        while (flag) {
            synchronized (object) {
                if (list.size() <= 0) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("消费者消费数据： " + list.remove(0));
                    object.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        final SynchronizedTest4 test = new SynchronizedTest4();

        Thread t1 = new Thread(() -> test.produce());
        Thread t2 = new Thread(() -> test.consume());

        t1.start();
        t2.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.setFlag(false);
    }
}
