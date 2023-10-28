package org.example.lesson_5_multithreading.races;

import java.util.concurrent.Semaphore;

import static org.example.lesson_5_multithreading.races.Main.CARS_COUNT;

public class Tunnel extends Stage {
    private final Semaphore smp;

    public Tunnel() {
        this.smp = new Semaphore(CARS_COUNT / 2);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            if (!smp.tryAcquire()) {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
            }
            System.out.println(c.getName() + " начал этап " + description);
            Thread.sleep(length / c.getSpeed() * 1000L);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            smp.release();
        }
    }
}
