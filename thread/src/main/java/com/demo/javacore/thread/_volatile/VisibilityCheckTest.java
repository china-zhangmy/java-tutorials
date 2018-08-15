package com.demo.javacore.thread._volatile;

/**
 * https://blog.csdn.net/chenchaofuck1/article/details/51702388
 * <p>
 * volatile的可见性：
 * 可见性指当一个线程修改了一个共享变量的值，其他线程能够立即得知这个修改。
 * <p>
 * Java的内存模型（JMM）：
 * Java内存模型规定所有的变量都放在主内存中，每条线程都有自己的工作内存，线程的工作内存中保存了被该线程使用到的变量的主内存副本拷贝，
 * 线程对变量的所有操作（读取、赋值等）都在工作内存中进行，不能直接读写主内存中的变量。
 * <p>
 * 线程、工作内存、主内存交互原子操作如下：
 * lock：作用于主内存，把变量标识为线程独占状态。
 * unlock：作用于主内存，解除独占状态。
 * read：作用主内存，把一个变量的值从主内存传输到线程的工作内存。
 * load：作用于工作内存，把read操作传过来的变量值放入工作内存的变量副本中。
 * use：作用工作内存，把工作内存当中的一个变量值传给执行引擎。
 * assign：作用工作内存，把一个从执行引擎接收到的值赋值给工作内存的变量。
 * store：作用于工作内存的变量，把工作内存的一个变量的值传送到主内存中。
 * write：作用于主内存的变量，把store操作传来的变量的值放入主内存的变量中。
 * <p>
 * volatile变量与普通变量的区别是：
 * volatile的特殊规则保证了新值能立即同步到主内存，以及每次使用前立即从主内存刷新，而普通变量则不能保证这一点。
 * <p>
 * volatile的特殊规则就是：
 * 线程中每次use变量时，都需要连续执行read->load->use几项操作，即所谓的每次使用都要从主内存更新变量值，这样其它线程的修改对该线程就是可见的。
 * 线程每次assign变量时，都需要连续执行assign->store->write几项操作，即所谓每次更新完后都会回写到主内存，这样使得其它线程读到的都是最新数据。
 * <p>
 * 应用场景：
 * volatile的可见性很适合用来控制并发
 */
public class VisibilityCheckTest {

    private static volatile boolean flag;

    public void shutdown() {
        flag = true;
    }

    public static void main(String[] args) {
        VisibilityCheckTest m = new VisibilityCheckTest();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                while (!flag) {

                }
            }).start();
        }

        m.shutdown();
    }

}
