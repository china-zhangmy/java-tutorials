package org.twinsdaddy.javatutorials.exercises.proxy.performance;

import org.twinsdaddy.javatutorials.exercises.proxy.performance.proxy.CglibProxySubject;
import org.twinsdaddy.javatutorials.exercises.proxy.performance.proxy.DynaProxySubject;
import org.twinsdaddy.javatutorials.exercises.proxy.performance.proxy.StaticProxySubject;

import java.util.LinkedHashMap;
import java.util.Map;

public class PerformanceTest {

    public static void main(String[] args) {
        //创建测试对象；
        Subject nativeSubject = new RealSubject();
        Subject staticProxySubject = new StaticProxySubject(nativeSubject);
        Subject dynamicProxySubject = DynaProxySubject.newProxyInstance(nativeSubject);
        Subject cglibProxySubject = CglibProxySubject.newProxyInstance(RealSubject.class);

        //预热一下；
        int preRunCount = 10000;
        runWithoutMonitor(nativeSubject, preRunCount);
        runWithoutMonitor(staticProxySubject, preRunCount);
        runWithoutMonitor(cglibProxySubject, preRunCount);
        runWithoutMonitor(dynamicProxySubject, preRunCount);

        //执行测试；
        Map<String, Subject> tests = new LinkedHashMap<String, Subject>();
        tests.put("Native   ", nativeSubject);
        tests.put("Static   ", staticProxySubject);
        tests.put("Dynamic  ", dynamicProxySubject);
        tests.put("Cglib    ", cglibProxySubject);
        int repeatCount = 3;
        int runCount = 1000000;
        runTest(repeatCount, runCount, tests);
        runCount = 50000000;
        runTest(repeatCount, runCount, tests);
    }

    private static void runTest(int repeatCount, int runCount, Map<String, Subject> tests) {
        System.out.println(String.format("\n==================== run test : [repeatCount=%s] [runCount=%s] [java.version=%s] ====================", repeatCount, runCount, System.getProperty("java.version")));
        for (int i = 0; i < repeatCount; i++) {
            System.out.println(String.format("\n--------- test : [%s] ---------", (i + 1)));
            for (String key : tests.keySet()) {
                runWithMonitor(tests.get(key), runCount, key);
            }
        }
    }

    private static void runWithoutMonitor(Subject test, int runCount) {
        for (int i = 0; i < runCount; i++) {
            test.test(i);
        }
    }

    private static void runWithMonitor(Subject test, int runCount, String tag) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < runCount; i++) {
            test.test(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("[" + tag + "] Elapsed Time:" + (end - start) + "ms");
    }
}
