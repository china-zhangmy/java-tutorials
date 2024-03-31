package org.twinsdaddy.javatutorials.exercises.thread.state;

public class TerminatedStateTest {

    public static void main(String[] args) throws InterruptedException {
        final ThreadTask task = new ThreadTask.Normal();

        Thread thread = new Thread(() -> task.concreteTask(), "Thread 1");
        thread.start();

        System.out.println("线程[" + thread.getName() + "]的当前状态： " + thread.getState());

        // 等待子线程运行
        System.out.println("等待线程[" + thread.getName() + "]正常结束");
        Thread.sleep(10000);

        System.out.println("线程[" + thread.getName() + "]的当前状态： " + thread.getState());
    }

}
