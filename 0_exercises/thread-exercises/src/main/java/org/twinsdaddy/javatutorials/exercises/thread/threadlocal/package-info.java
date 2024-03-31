/**
 * ThreadLocal —— 线程本地变量/线程本地存储
 * <p>
 * ThreadLocal在每个线程中对该变量会创建一个副本，即每个线程内部都会有一个该变量，且在线程内部任何地方都可以使用，线程之间互不影响，
 * 这样一来就不存在线程安全问题，也不会严重影响程序执行性能。但是要注意，虽然ThreadLocal能够解决上面说的问题，但是由于在每个线程中都创建了副本，
 * 所以要考虑它对资源的消耗，比如内存的占用会比不使用ThreadLocal要大。
 * <p>
 * 总结：
 * 　　1）实际的通过ThreadLocal创建的副本是存储在每个线程自己的threadLocals中的；
 * 　　2）为何threadLocals的类型ThreadLocalMap的键值为ThreadLocal对象，因为每个线程中可有多个threadLocal变量，就像上面代码中的longLocal和stringLocal；
 * 　　3）在进行get之前，必须先set，否则会报空指针异常；
 * <p>
 * 共享变量 vs ThreadLocal
 * <p>
 * 概括起来说，对于多线程资源共享的问题，同步机制采用了“以时间换空间”的方式，而ThreadLocal采用了“以空间换时间”的方式。
 * 前者仅提供一份变量，让不同的线程排队访问，而后者为每一个线程都提供了一份变量，因此可以同时访问而互不影响。
 */
package org.twinsdaddy.javatutorials.exercises.thread.threadlocal;