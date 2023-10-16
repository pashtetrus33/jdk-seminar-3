package org.example.lection3_generics;

// extends RuntimeException исключение обобщенного типа создать нельзя.
// интерфейсы обобщенного типа бывают
public class GBox<T> {
    private T value;

    //инициализировать нельзя, можно лишь подать снаружи
    private T[] valueArray;

    //Static field with type T is not allowed
    //private static T staticValue;


    public GBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void printInfo() {
        System.out.printf("GBox (%s): %s\n", value.getClass().getSimpleName(), value);
    }

    public void methodOne() {
        //Так создать нельзя
        //T data = new T();
    }

    public void methodTwo(T[] arr) {
        // Cоздавать массив из T нельзя, но можно такой массив подать снаружи
        valueArray = arr;

    }


    //Обобщенные методы - можно делать статические, нестатические и конструкторы
    // Параметры типа аргументов указывается в скобках до возвращаемого типа
    public <T> void setIfNull(GBox<T> box, T t) {
        if (box.getValue() == null) {
            box.setValue(t);
        }
    }
}
