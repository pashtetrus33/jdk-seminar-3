package org.example.lesson_5_multithreading.p1_thread_creation_and_base;

public class ThreadOrderApp_7 {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(1)).start();

        new Thread(() -> System.out.println(2)).start();
    }
}
