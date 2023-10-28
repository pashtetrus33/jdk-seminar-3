package org.example.lesson_5_multithreading.p1_thread_creation_and_base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceApp_4 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            final int w = i;
            service.submit(() -> {
                System.out.println(w + " - Begin");
                try {
                    Thread.sleep(100 + (int) (3000 * Math.random()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(w + " - End");
            });
        }
        service.shutdown();
    }
}
