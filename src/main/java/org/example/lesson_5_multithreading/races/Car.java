package org.example.lesson_5_multithreading.races;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static AtomicInteger ai;
    private final Race race;
    private String name;
    private int speed;
    private CyclicBarrier barrier;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    static {
        CARS_COUNT = 0;
        ai = new AtomicInteger(0);
    }

    public Car(Race race, int speed, CyclicBarrier barrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            barrier.await();
            barrier.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            //static Object monitor = new Object();
            //static boolean haveWinner = false;
            //synchronized (monitor){
            //if (!haveWinner){
            //haveWinner = true;
            //System.out.println(name + " WIN");
            // }
            // }

            //или (не очень правилный замок остается захваченный)
            //lock.tryLock();
            //boolean...


            if (ai.incrementAndGet() == 1) {
                System.out.println(name + " - WIN");
            }
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
