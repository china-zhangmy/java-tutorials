/**
 * https://blog.csdn.net/u011784767/article/details/51428101
 * <p>
 * 如果你使用过杀毒软件，可能会发现全盘杀毒太耗时间了，这时你如果点击取消杀毒按钮，那么此时你正在中断一个运行的线程。
 * Java为我们提供了一种调用interrupt()方法来请求终止线程的方法，下面我们就一起来学习一下线程的中断。
 * <p>
 * 每一个线程都有一个boolean类型标志，用来表明当前线程是否请求中断，当一个线程调用interrupt() 方法时，线程的中断标志将被设置为true。
 * 我们可以通过调用Thread.currentThread().isInterrupted()或者Thread.interrupted()来检测线程的中断标志是否被置位。这两个方法的区别是
 * Thread.currentThread().isInterrupted()是线程对象的方法，调用它后不清除线程中断标志位；而Thread.interrupted()是一个静态方法，
 * 调用它会清除线程中断标志位。
 * <p>
 * Thread.currentThread().isInterrupted()：        对象方法        不清除中断标志位
 * Thread.interrupted()：                          静态方法        清除中断标志位(设置为false)
 * <p>
 * 所以说调用线程的interrupt() 方法不会中断一个正在运行的线程，这个机制只是设置了一个线程中断标志位，如果在程序中你不检测线程中断标志位，
 * 那么即使设置了中断标志位为true，线程也一样照常运行。
 * <p>
 * 一般来说中断线程分为三种情况：
 * <p>
 * (一) 中断非阻塞线程 - InterruptNonBlockedThread
 * (二) 中断阻塞线程 - InterruptBlockedThread
 * (三) 不可中断线程 - NonInterruptibleThread
 */
package thread.interruption;