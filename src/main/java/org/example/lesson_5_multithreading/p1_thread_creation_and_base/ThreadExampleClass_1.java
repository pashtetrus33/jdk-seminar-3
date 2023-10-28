package org.example.lesson_5_multithreading.p1_thread_creation_and_base;

// Минусы - закрывает возможность наследования от еще какого-то класса
// Плюсы - используется если нужно хитро продркутить поведение создаваемого потока
public class ThreadExampleClass_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread-" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new ThreadExampleClass_1();
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main-" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
