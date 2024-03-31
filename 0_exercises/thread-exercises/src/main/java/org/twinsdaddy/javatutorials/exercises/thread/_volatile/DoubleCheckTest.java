package org.twinsdaddy.javatutorials.exercises.thread._volatile;

/**
 * https://blog.csdn.net/chenchaofuck1/article/details/51702388
 * <p>
 * 如果代码中的instance不使用volatile，这段代码可能出现问题，可能出现把未进行初始化的对象赋值给instance，
 * 这时instance已经是非null了，如果在其他现在当中使用这个未被初始化的对象将会出现安全问题。
 */
public class DoubleCheckTest {

    private volatile static DoubleCheckTest instance = null;

    private DoubleCheckTest() {
        // TODO sth for initialization
    }

    public static DoubleCheckTest getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckTest.class) {
                if (instance == null)
                    instance = new DoubleCheckTest();
            }
        }
        return instance;
    }

}
