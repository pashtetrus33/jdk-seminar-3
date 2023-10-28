package org.example.lesson_5_multithreading.p1_thread_creation_and_base;

import java.util.Arrays;

public class DaemonExample_5 {
    public static void main(String[] args) {
        Thread tTimer = new Thread(() -> {
            int time = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    time++;
                    System.out.println("time: " + time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        tTimer.setDaemon(true);
        tTimer.start();
        System.out.println("Thread state: " + tTimer.getState());
        System.out.println("Name: " + tTimer.getName());
        System.out.println("id: " + tTimer.getId());
        System.out.println("StackTrace: " + Arrays.toString(tTimer.getStackTrace()));
        System.out.println(tTimer.isAlive());
        System.out.println(Thread.currentThread().getState());
        System.out.println("main -> sleep");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Пока есть хотя бы один обычный поток в приложении (не демон) будет работать демоны иначе все завершается.
        System.out.println("main -> end");
    }
}
