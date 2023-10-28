package org.example.lesson_5_multithreading.p8_wait_notify;

import java.util.concurrent.atomic.AtomicInteger;

public class MyTest {
    private AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        MyTest myTest = new MyTest();
        Object mon = new MyTest();

        Thread threadCounterSetter = new Thread(() -> {
            for (int i = 0; i < 1_0000; i++) {
                synchronized (mon) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    myTest.counter.incrementAndGet();
                }
            }
        });

        Thread threadCounterGetter = new Thread(() -> {
            for (int i = 0; i < 1_0000; i++) {
                synchronized (mon) {

                    try {
                       Thread.sleep(1);
                        System.out.println(myTest.counter);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });

        threadCounterSetter.start();
        threadCounterGetter.start();
        threadCounterGetter.join();
        threadCounterSetter.join();
        System.out.println("Final count " + myTest.counter);

    }

}
