package org.example.lesson_5_multithreading.p1_thread_creation_and_base;

public class ThreadStopApp_6 {
    public static void main(String[] args) {correct();
    }

    public static void correct() {
        Thread t = new Thread(() -> {
            boolean inter = false;
            while (!Thread.currentThread().isInterrupted() && !inter) {
                System.out.println("tick");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    inter = true;
                    //or break;
                }
            }
        });
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }

    public static void badIdea() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("tick");
            }
        });
        t.start();

        try {
            Thread.sleep(3000);
            t.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
