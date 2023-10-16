package org.example.seminar3;

import org.example.seminar3.task1.OwnCollection;
import org.example.seminar3.task1.task2.Calculator;
import org.example.seminar3.task1.task4.Pair;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Task 1 В коллекции вложенный класс инетратор
        System.out.println("_________TASK 1 ___________________________________________________________");
        OwnCollection<String> stringOwnCollection = new OwnCollection<>();

        stringOwnCollection.add("How");
        stringOwnCollection.add("are");
        stringOwnCollection.add("you");
        stringOwnCollection.add("today");
        stringOwnCollection.add("?");
        stringOwnCollection.info();
        stringOwnCollection.remove("today");
        stringOwnCollection.info();

        for (String str : stringOwnCollection.getIterator()) {
            System.out.println(str);
        }
        // Task 2 Необобщенный класс калькулятор со обобщенными статическими методами с параметрами наследниками Number
        System.out.println("_________TASK 2 ___________________________________________________________");
        Calculator.addition(3, 4f);
        Calculator.subtraction(3, 2.34);
        Calculator.multiplication(-2.6, 4f);
        Calculator.division(3, 4);

        // Task 3 Обобщенный метод compareArrays принимает два массива возвращает true если одинаковые false в любом другом случае.
        // Тип данных любой (но оба одинаковые), размеры одинаковые.
        System.out.println("_________TASK 3 ___________________________________________________________");
        // String[] arr1 = {new String("Hello"), ",", "world", "!"};
        // String[] arr2 = {"Hello", ",", "world", "!"};
        // Integer[] arr1 = {3, 4, 5, 6, 7};
        // Integer[] arr2 = {3, 4, 5, 6, 7};

        Float[] arr1 = {3.45f, 4f, 5f, 6f, 7f};
        Float[] arr2 = {3.45f, 4f, 5f, 6f, 7f};

        System.out.println("Arrays:\n" + Arrays.toString(arr1) + "\n" + Arrays.toString(arr2) + "\nare equal: " + compareArrays(arr1, arr2));

        // Task 4 Обобщенный класс Pair, который представляет пару значений разного типа имеет методы геттеры для первого
        // и второго значения и переопределенный метод toString, возвращающий строчку с обоими значениями.
        System.out.println("_________TASK 4 ___________________________________________________________");
        Pair<Integer, String> pair = new Pair<>(3, "Apple");
        System.out.println("First element: " + pair.getKey());
        System.out.println("Second element: " + pair.getValue());
        System.out.println(pair);
    }

    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
}