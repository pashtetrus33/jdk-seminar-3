package org.example.lection3_generics.hw;

public abstract class Fruit {
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    protected float getWeight() {
        return weight;
    }
}
