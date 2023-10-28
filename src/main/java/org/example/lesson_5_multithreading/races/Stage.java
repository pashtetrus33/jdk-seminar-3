package org.example.lesson_5_multithreading.races;

public abstract class Stage {
    protected int length;
    protected String description;

    public abstract void go(Car c);
}
