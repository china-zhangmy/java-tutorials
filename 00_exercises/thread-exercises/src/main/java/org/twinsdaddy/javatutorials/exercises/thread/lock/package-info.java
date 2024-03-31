/**
 * https://blog.csdn.net/u011784767/article/details/51439327
 * <p>
 * 在大多数实际的多线程应用中，两个或两个以上的线程需要共享对同一数据的存取。如果两个线程存取相同的对象，并且每一个线程
 * 都调用了一个修改该对象状态的方法，那么线程彼此踩了对方的脚，根据各线程访问数据的次序，可能会产生讹误的对象。这样的一种现象称之为竞争条件。
 * <p>
 * 当然多个线程共享一个变量在实际的应用中有时难以避免，但是我们可以通过Java提供的一些技术来避免线程彼此踩脚的行为发生。
 * <p>
 * Java提供了锁机制来对多个线程共享一个变量进行同步，在java SE 5.0引入了显式锁ReentrantLock类，以及从1.0版本开始的对象内部锁
 * 可以通过synchronized关键字声明某个线程持有这个对象内部锁。
 */
package org.twinsdaddy.javatutorials.exercises.thread.lock;