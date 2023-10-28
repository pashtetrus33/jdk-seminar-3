package org.example.lesson_5_multithreading.hw1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    private static final int SIZE = 100_000_000;
    private static final int HALF = SIZE / 2;
    private static final float[] arr = new float[SIZE];

    public static void main(String[] args) throws InterruptedException {
        arrayCompute(arr);
        arrayComputeWithTwoThreads(arr);
    }

    public static void fillArray(float[] arr) {
        IntStream.range(0, arr.length).forEach(i -> arr[i] = 1);
        //Arrays.fill(arr, 1.0f);
    }

    public static void arrayCompute(float[] arr) {
        fillArray(arr);
        //System.out.println(Arrays.toString(arr));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) ((arr[i] * Math.sin(0.2f + i / 5)) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long duration = System.currentTimeMillis() - begin;
        System.out.println("Time: " + duration);
        //System.out.println(Arrays.toString(arr));
    }

    public static void arrayComputeWithTwoThreads(float[] arr) throws InterruptedException {
        fillArray(arr);
        //System.out.println(Arrays.toString(arr));
        long begin = System.currentTimeMillis();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float) ((a1[i] * Math.sin(0.2f + i / 5)) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0, j = HALF; i < a2.length; i++, j++) {
                a2[i] = (float) ((a2[i] * Math.sin(0.2f + j / 5)) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        long duration = System.currentTimeMillis() - begin;
        System.out.println("Time with threads: " + duration);
        //System.out.println(Arrays.toString(arr));
    }

}
