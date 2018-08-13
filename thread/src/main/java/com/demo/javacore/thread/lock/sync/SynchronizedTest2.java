package com.demo.javacore.thread.lock.sync;

/**
 * (2)synchronized关键字获得的锁是可重入锁
 */
public class SynchronizedTest2 {

    public static class ParentSynchronized {
        //父类同步方法
        public synchronized void parentMethod() {
            System.out.println("parent invoke");
        }
    }


    public static class ChildrenSynchronized extends ParentSynchronized {

        // 子类同步方法
        public synchronized void childrenMethod() {
            System.out.println("children invoke");
            parentMethod();
        }

    }

    public static void main(String[] args) {
        final ChildrenSynchronized cs = new ChildrenSynchronized();

        new Thread(() -> cs.childrenMethod()).start();
    }

}
