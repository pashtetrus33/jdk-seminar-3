package org.example.lection3_generics.hw;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    ArrayList<T> arrayList;

    public Box() {
        this.arrayList = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        arrayList.add(fruit);
    }

    public void deleteFruit(T fruit) {
        arrayList.remove(fruit);
    }

    public float getWeight() {
        float result = 0;
        for (T fruit : arrayList) {
            result += fruit.getWeight();
        }
        return result;
    }


    public boolean compare(Box<? extends Fruit> anotherBox) {

        return this.getWeight() == anotherBox.getWeight();
    }
}
