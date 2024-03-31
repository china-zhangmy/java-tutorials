package org.twinsdaddy.javatutorials.exercises.thread.thread_runnable_callable;

/**
 * 优点：代码相对其他两种方式更简洁
 * <p>
 * 缺点：由于java的继承机制是单一继承，继承Thread类就不能继承其他的类。
 */
public class ExtendsThread extends Thread {

    public ExtendsThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("[Thread Name] " + getName() + " [Thread ID] " + getId());
    }

    public static void main(String[] args) {
        // 输出主线程的相关信息
        System.out.println("[Thread Name] " + Thread.currentThread().getName() + " [Thread ID] " + Thread.currentThread().getId());

        // 通过实例直接创建线程
        new ExtendsThread("Thread 1").start();
        new ExtendsThread("Thread 2").start();
    }
}
