package thread.thread_runnable_callable;

import java.util.concurrent.*;

/**
 * 希望得到线程的计算结果
 */
public class ImplementsCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 35;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ImplementsCallable callable = new ImplementsCallable();

        // 创建包装器 FutureTask 同时实现了Runnable和Future接口 可以将Callable 转换成Future和Runnable
        FutureTask task = new FutureTask(callable);
        new Thread(task).start();

        //  调用FutureTask.get() 方法 获取线程的计算结果
        //  如果线程没有计算完结果 则get()方法会阻塞 直到线程计算完结果返回
        System.out.println(task.get());
        //  调用FutureTask.get(long timeout, TimeUnit unit)方法在指定时间内获取线程计算结果，超时则抛出 TimeoutException异常
        //  如果运行计算结果的线程被中断则get()和get(long timeout, TimeUnit unit)方法都将抛出InterruptedException异常
        System.out.println(task.get(10000, TimeUnit.MILLISECONDS));

    }

}
