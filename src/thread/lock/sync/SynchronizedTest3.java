package thread.lock.sync;

/**
 * (3)synchronized关键字修饰类的静态方法
 */
public class SynchronizedTest3 {

    // synchronized关键字修饰静态方法 同步方法
    public synchronized static void printNum1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    // synchronized关键字使用类锁   同步代码块
    public static void printNum2() {
        synchronized (SynchronizedTest2.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }

    // synchronized关键字修饰 同步方法  这里使用的是对象锁
    public synchronized void printNum3() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        final SynchronizedTest3 test = new SynchronizedTest3();

        Thread t1 = new Thread(() -> SynchronizedTest3.printNum1(), "A");
        Thread t2 = new Thread(() -> SynchronizedTest3.printNum2(), "B");
        Thread t3 = new Thread(() -> test.printNum3(), "C");

        t1.start();
        t2.start();
        t3.start();
    }

}
