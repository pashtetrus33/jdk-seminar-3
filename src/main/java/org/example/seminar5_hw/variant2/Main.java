package org.example.seminar5_hw.variant2;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

//Есть пять философов (потоки), которые могут либо обедать либо размышлять.
//Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
//После каждого приема пищи философ должен размышлять
//Не должно возникнуть общей блокировки
//Философы не должны есть больше одного раза подряд
public class Main {
    static final int PHILOSOPHERS_COUNT = 5;
    private static final int MAX_EAT_COUNT = 3;

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier barrier = new CyclicBarrier(PHILOSOPHERS_COUNT + 1);
        Lock lock =  new ReentrantLock();
        IntStream.range(1, PHILOSOPHERS_COUNT + 1).forEach((i) -> new Thread(new Philosopher(barrier, MAX_EAT_COUNT,lock)).start());
        barrier.await();
        System.out.println("All philosophers eat " + MAX_EAT_COUNT + " times");
    }
}
