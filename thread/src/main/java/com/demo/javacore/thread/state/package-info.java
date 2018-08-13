/**
 * https://blog.csdn.net/u011784767/article/details/51329709
 *
 * Java线程总共有6中状态（Thread.State）：
 * <p>
 * (1)New (新创建)
 * (2)Runnable (可运行)
 * (3)Blocked (被阻塞)
 * (4)Waiting (等待)
 * (5)Timed Waiting (计时等待)
 * (6)Terminated (被终止)
 * <p>
 * 场景
 * <p>
 * (1)New
 * * Thread com.demo.javacore.thread = new Thread();
 * (2)Runnable
 * * Thread.start();
 * (3)Blocked
 * * synchronized(lock)
 * (4)Waiting - the following methods invoked without args
 * * synchronized(lock) { Object.wait }
 * * Thread.sleep
 * * Thread.join
 * * ReentrantLock.lock
 * * Condition.await
 * (5)Timed Waiting - the following methods invoked with args
 * * synchronized(lock) { Object.wait }
 * * Thread.sleep
 * * Thread.join
 * * ReentrantLock.tryLock
 * * Condition.await
 * (6)Terminated
 * * Complete normally
 * * Die exceptionally
 */
package com.demo.javacore.thread.state;