package org.twinsdaddy.javatutorials.exercises.thread._volatile;

/**
 * https://blog.csdn.net/chenchaofuck1/article/details/51702388
 * <p>
 * volatile不能保证线程安全
 * <p>
 * volatile关键字是JAVA并行开发中非常重要的一个关键字，但却常被误以为其具有证原子性，实际上volatile修饰的便利不能保证线程安全。
 * 这段代码创建20个线程对count自加操作，但最后count不是200，每次运行的结果都不一样，问题就在count++语句。用javap反编译就可以发现
 * 该语句由4条字节码指令构成，从字节码层面就很容易分析出原因：执行取值指令时，可以保证count是最新，但当执行iadd指令时，
 * 其他线程可能已经更新count了，而现在操作的count已经过期了，所以可能把较小的count同步回主内存中。
 *
 * 限制条件：当且仅当满足以下所有条件时，才应该使用volatile变量
 * 1、对变量的写入操作不依赖变量的当前值，或者你能确保只有单个线程更新变量的值。
 * 2、该变量没有包含在具有其他变量的不变式中。
 */
public class UnsafeVolatileTest {

    private static volatile int count = 0;

    public static void increase() {
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    increase();
                }
            }).start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(count);
    }
}
