package com.demo.javacore.thread.state;

public class RunnableStateTest {

    public static void main(String[] args) {
        final ThreadTask task = new ThreadTask.Normal();

        Thread thread = new Thread(() -> task.concreteTask(), "Thread 1");
        thread.start();
        System.out.println("线程[" + thread.getName() + "]的当前状态： " + thread.getState());
    }

}
