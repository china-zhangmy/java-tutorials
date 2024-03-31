package org.twinsdaddy.javatutorials.exercises.thread.threadlocal;


public class ThreadLocalTest {

    private static ThreadLocal<Long> id = ThreadLocal.withInitial(() -> Thread.currentThread().getId());
    private static ThreadLocal<String> name = ThreadLocal.withInitial(() -> Thread.currentThread().getName());

    public Long getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest test = new ThreadLocalTest();

        System.out.println(test.getId());
        System.out.println(test.getName());

        Thread threadChild = new Thread(() -> {
            System.out.println(test.getId());
            System.out.println(test.getName());
        }, "Child Thread");

        threadChild.start();
        threadChild.join();

        System.out.println(test.getId());
        System.out.println(test.getName());
    }

}
