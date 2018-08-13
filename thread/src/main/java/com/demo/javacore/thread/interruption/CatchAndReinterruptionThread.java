package com.demo.javacore.thread.interruption;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 在什么场景下，我们需要在catch块里面中断线程（重置中断状态）呢？
 * * Answer: 如果不能抛出InterruptedException（就像这里的Thread.sleep语句放在了Runnable的run方法中，这个方法不允许抛出任何受检查的异常），
 * * 但又想告诉上层调用者这里发生了中断的时候，就只能在catch里面重置中断状态了。一个比较合理的解释是：一个中断应该只被处理一次
 * * （你catch了这个InterruptedException，说明你能处理这个异常，你不希望上层调用者看到这个中断）
 */
public class CatchAndReinterruptionThread {

    public static class TaskRunner implements Runnable {
        private BlockingQueue<Object> queue;

        public TaskRunner(BlockingQueue<Object> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while (true) {
                    Object task = queue.take();
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted");
                System.out.println(Thread.currentThread().getName() + "'s interrupt status is " + Thread.currentThread().isInterrupted());
                // Restore the interrupted status
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " is reinterrupted");
                System.out.println(Thread.currentThread().getName() + "'s interrupt status is " + Thread.currentThread().isInterrupted());
            }
        }
    }

    public static void main(String[] args) {
        Thread childThread = new Thread(new TaskRunner(new LinkedBlockingDeque<>()), "Child Thread");
        childThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        childThread.interrupt();
    }

}
