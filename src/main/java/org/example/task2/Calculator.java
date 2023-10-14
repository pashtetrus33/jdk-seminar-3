package org.example.task2;

public class Calculator {
    public static <T extends Number> void addition(T a, T b) {
        System.out.println("Сумма чисел: " + a.doubleValue() + " + " + b.doubleValue() + " = " + (a.doubleValue() + b.doubleValue()));
    }

    public static <T extends Number> void subtraction(T a, T b) {
        System.out.println("Разность чисел: " + a.doubleValue() + " - " + b.doubleValue() + " = " + (a.doubleValue() - b.doubleValue()));
    }

    public static <T extends Number> void multiplication(T a, T b) {
        System.out.println("Произведение чисел: " + a.doubleValue() + " * " + b.doubleValue() + " = " + (a.doubleValue() * b.doubleValue()));
    }

    public static<T extends Number> void division(T a, T b) {
        System.out.print("Частное чисел: " + a.doubleValue() + " / " + b.doubleValue() + " = ");
        if (b.doubleValue() != 0)
            System.out.println((a.doubleValue() / b.doubleValue()));
        else throw new ArithmeticException("Деление на ноль!");
    }
}
