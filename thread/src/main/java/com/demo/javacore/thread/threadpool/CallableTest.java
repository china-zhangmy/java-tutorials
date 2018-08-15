package com.demo.javacore.thread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Output Sample:
 * 程序开始执行
 * Task 0 开始执行>>>>
 * Task 1 开始执行>>>>
 * Task 2 开始执行>>>>
 * Task 3 开始执行>>>>
 * Task 4 开始执行>>>>
 * Task 0 执行完毕>>>>
 * Task 0 总耗时: 2300
 * Task 4 执行完毕>>>>
 * Task 1 执行完毕>>>>
 * Task 1 总耗时: 5509
 * Task 2 执行完毕>>>>
 * Task 2 总耗时: 7608
 * Task 3 执行完毕>>>>
 * Task 3 总耗时: 9068
 * Task 4 总耗时: 3538
 */
public class CallableTest {

    public static void main(String[] args) {
        System.out.println("程序开始执行");

        List<Future> lst = new ArrayList<>();
        int taskSize = 5;

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < taskSize; i++) {
            MyCallable task = new MyCallable("Task " + i);
            Future<String> future = pool.submit(task);

            lst.add(future);
        }

        for (Future<String> future : lst) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();
    }

}

class MyCallable implements Callable<String> {

    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println(name + " 开始执行>>>>");

        long beginTime = System.currentTimeMillis();
        Thread.sleep(new Random().nextInt(10000));
        long endTime = System.currentTimeMillis();

        System.out.println(name + " 执行完毕>>>>");
        return name + " 总耗时: " + (endTime - beginTime);
    }
}
