package org.twinsdaddy.javatutorials.exercises.thread.state;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ThreadTask implements ConcreteService {

    public static class Normal extends ThreadTask {

        public void concreteTask() {
            System.out.println("线程开始执行");

            System.out.println("线程正在执行具体任务-5秒");
            // 模拟线程耗时操作
            long beginTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - beginTime < 5000) ;

            System.out.println("线程执行完毕");
        }

    }

    public static class Blocked extends ThreadTask {

        private Object lock = new Object();

        @Override
        public void concreteTask() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "线程开始执行");

                System.out.println(Thread.currentThread().getName() + "线程正在执行具体任务-5秒");
                // 模拟线程耗时操作
                long beginTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - beginTime < 5000) ;

                System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            }
        }

    }

    public abstract static class Waiting {

        public static class JoinMode extends ThreadTask {

            @Override
            public void concreteTask() {
                System.out.println(Thread.currentThread().getName() + "线程开始执行");

                System.out.println(Thread.currentThread().getName() + "线程正在执行具体任务-5秒");

                Thread thread2 = new Thread(new Runnable() {
                    public void run() {
                        System.out.println("Thread 2 is running");
                        // 模拟线程耗时操作
                        long beginTime = System.currentTimeMillis();
                        while (System.currentTimeMillis() - beginTime < 5000) {
                        }
                        System.out.println("Thread 2 is stop");
                    }
                }, "Thread 2");

                thread2.start();
                try {
                    // 线程thread2抢占资源开始执行，当前线程在thread2死亡前一直处于WAITING状态
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            }
        }

        public static class ReentrantLockMode extends ThreadTask {

            ReentrantLock lock = new ReentrantLock();

            @Override
            public void concreteTask() {
                lock.lock();

                try {
                    System.out.println(Thread.currentThread().getName() + "线程开始执行");

                    System.out.println(Thread.currentThread().getName() + "线程正在执行具体任务-5秒");
                    // 模拟线程耗时操作
                    long beginTime = System.currentTimeMillis();
                    while (System.currentTimeMillis() - beginTime < 5000) ;

                    System.out.println(Thread.currentThread().getName() + "线程执行完毕");
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    public abstract static class TimedWaiting {

        public static class JoinMode extends ThreadTask {

            @Override
            public void concreteTask() {
                System.out.println(Thread.currentThread().getName() + "线程开始执行");

                System.out.println(Thread.currentThread().getName() + "线程正在执行具体任务-5秒");

                Thread thread2 = new Thread(new Runnable() {
                    public void run() {
                        System.out.println("Thread 2 is running");
                        // 模拟线程耗时操作
                        System.out.println("Thread 2 计划执行5秒");
                        long beginTime = System.currentTimeMillis();
                        while (System.currentTimeMillis() - beginTime < 5000) {
                        }
                        System.out.println("Thread 2 is stop");
                    }
                }, "Thread 2");

                thread2.start();
                try {
                    // 线程thread2抢占资源开始执行，当前线程在thread2死亡前1秒内处于WAITING状态
                    long beginTime = System.currentTimeMillis();
                    thread2.join(2000);
                    System.out.println("Thread 2 实际执行" + (System.currentTimeMillis() - beginTime) / 1000 + "秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            }
        }

        public static class ReentrantLockMode extends ThreadTask {

            ReentrantLock lock = new ReentrantLock();

            @Override
            public void concreteTask() {
                boolean lockSucc = false;
                try {
                    System.out.println(Thread.currentThread().getName() + "线程尝试2纳秒内获取锁...");
                    lockSucc = lock.tryLock(2000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (lockSucc) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "线程获取锁成功， 开始执行");

                        System.out.println(Thread.currentThread().getName() + "线程正在执行具体任务-5秒");
                        // 模拟线程耗时操作
                        long beginTime = System.currentTimeMillis();
                        while (System.currentTimeMillis() - beginTime < 5000) ;

                        System.out.println(Thread.currentThread().getName() + "线程执行完毕");
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "线程获取锁失败");
                }
            }
        }
    }

}

interface ConcreteService {

    void concreteTask();

}
