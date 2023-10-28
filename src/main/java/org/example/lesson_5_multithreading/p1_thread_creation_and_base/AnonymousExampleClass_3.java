package org.example.lesson_5_multithreading.p1_thread_creation_and_base;

public class AnonymousExampleClass_3 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        try {
            //Здесь ждем заверешине потока t
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END");
    }
}
