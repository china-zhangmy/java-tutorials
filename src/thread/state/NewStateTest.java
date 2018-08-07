package thread.state;

/**
 * 当我们执行new Thread(target)时，JVM要为线程的运行做一些前期的准备工作，比如：
 * 1）检查线程类是否已经被加载、解析和初始化过
 * 2）接下来还要为对象分配空间并对空间初始化零值
 * 3）接下来还要对对象进行一些类的元数据信息、对象的GC分年代等的设置信息
 * 等，当完成这些准备工作时线程才能进入到下一个Runnable (可运行)状态。所以说当业务需要频繁创建线程时，
 * 最好使用线程池，提高效率减轻JVM的压力。当然如果大量线程进行频繁上下文切换，此时多线程的效率会大打折扣。
 */
public class NewStateTest {

    public static void main(String[] args) {
        final ThreadTask task = new ThreadTask.Normal();

        Thread thread = new Thread(() -> task.concreteTask(), "Thread 1");
        System.out.println("线程[" + thread.getName() + "]的当前状态： " + thread.getState());
    }

}
