package org.example.lection3_generics.hw;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {2, 3, 4, 0, 5, 6, 67, 4, 3};
        String[] stringArray = {"Ivan", "Mariia", "Roma", "Katya"};
        System.out.println(Arrays.toString(array));
        changeArrElements(array, 3, 4);
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(stringArray));
        changeArrElements(stringArray, 0, 2);
        System.out.println(Arrays.toString(stringArray));

        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();

        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        //orangeBox.addFruit(new Orange());

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        System.out.println("Orange box weight: " + orangeBox.getWeight());
        System.out.println("Apple box weight: " + appleBox.getWeight());

        System.out.println(orangeBox.compare(appleBox));

    }

    public static <T> void changeArrElements(T[] arr, int index1, int index2) {
        if (arr.length < index1 || arr.length < index2 || index1 < 0 || index2 < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
