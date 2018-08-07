package thread.state;

public class BlockedStateTest {

    public static void main(String[] args) throws InterruptedException {
        final ThreadTask task = new ThreadTask.Blocked();

        Thread thread1 = new Thread(() -> task.concreteTask(), "Thread 1");
        Thread thread2 = new Thread(() -> task.concreteTask(), "Thread 2");

        thread1.start();
        thread2.start();

        // 等待子线程运行
        Thread.sleep(1000);

        System.out.println(thread1.getName() + " : " + thread1.getState());
        System.out.println(thread2.getName() + " : " + thread2.getState());
    }
}
