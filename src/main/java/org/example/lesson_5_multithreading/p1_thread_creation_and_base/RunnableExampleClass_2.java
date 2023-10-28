package org.example.lesson_5_multithreading.p1_thread_creation_and_base;

public class RunnableExampleClass_2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new RunnableExampleClass_2());
        t.start();
    }
}
