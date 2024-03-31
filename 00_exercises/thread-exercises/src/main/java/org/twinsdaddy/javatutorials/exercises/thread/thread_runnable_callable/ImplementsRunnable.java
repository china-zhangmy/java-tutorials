package org.twinsdaddy.javatutorials.exercises.thread.thread_runnable_callable;

/**
 * 优点：(1) 创建线程的同时可以继承其他的类，从而可以扩展类的功能。
 * (2) 同一个实现Runnable接口的实例可以作为多个Thread的target,这样可以实现资源的共享。
 * <p>
 * 缺点：相对于继承Thread类，实现Runnable接口代码要繁琐一些
 */
public class ImplementsRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("[Thread Name] " + Thread.currentThread().getName() + " [Thread ID] " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        // 输出主线程的相关信息
        System.out.println("[Thread Name] " + Thread.currentThread().getName() + " [Thread ID] " + Thread.currentThread().getId());

        // 通过模板创建线程
        ImplementsRunnable target = new ImplementsRunnable();
        new Thread(target, "Thread 1").start();

        // 通过内部类创建线程
        new Thread(() -> System.out.println("[Thread Name] " + Thread.currentThread().getName() + " [Thread ID] " + Thread.currentThread().getId()), "Thread 2").start();
    }

}
