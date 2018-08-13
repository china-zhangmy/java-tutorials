package com.demo.javacore.thread._volatile;

/**
 * https://blog.csdn.net/chenchaofuck1/article/details/51702388
 * <p>
 * volatile不能保证线程安全
 * <p>
 * volatile关键字是JAVA并行开发中非常重要的一个关键字，但却常被误以为其具有证原子性，实际上volatile修饰的便利不能保证线程安全。
 * 这段代码创建20个线程对count自加操作，但最后count不是200，每次运行的结果都不一样，问题就在count++语句。用javap反编译就可以发现
 * 该语句由4条字节码指令构成，从字节码层面就很容易分析出原因：执行取值指令时，可以保证count是最新，但当执行iadd指令时，
 * 其他线程可能已经更新count了，而现在操作的count已经过期了，所以可能把较小的count同步回主内存中。
 */
public class VolatileTest {

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
