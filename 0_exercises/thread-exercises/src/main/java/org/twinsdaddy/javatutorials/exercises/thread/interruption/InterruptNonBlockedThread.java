package org.twinsdaddy.javatutorials.exercises.thread.interruption;

/**
 * 中断非阻塞线程通常有两种方式：
 * (1) 采用线程共享变量
 * (2) 采用中断机制
 */
public class InterruptNonBlockedThread {

    /**
     * Note: 共享变量必须设置为volatile，这样才能保证修改后其他线程立即可见
     */
    public static class SharedVariableMode extends Thread {

        volatile boolean isStop = false;

        @Override
        public void run() {
            while (!isStop) {
                long beginTime = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName() + " is running");
                // 当前线程每隔一秒钟检测一次线程共享变量是否得到通知
                while (System.currentTimeMillis() - beginTime < 1000) ;
            }

            if (isStop) {
                System.out.println(Thread.currentThread().getName() + " is interrupted");
            }
        }

        public static void main(String[] args) {
            SharedVariableMode thread = new SharedVariableMode();
            thread.start();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 线程共享变量设置为true
            thread.isStop = true;
        }
    }

    public static class InterruptionMode extends Thread {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                long beginTime = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName() + " is running");
                // 当前线程每隔一秒钟检测一次线程共享变量是否得到通知
                while (System.currentTimeMillis() - beginTime < 1000) ;
            }

            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " is interrupted");
            }
        }

        public static void main(String[] args) {
            InterruptionMode thread = new InterruptionMode();
            thread.start();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 设置线程的中断标志位
            thread.interrupt();
        }
    }

}
