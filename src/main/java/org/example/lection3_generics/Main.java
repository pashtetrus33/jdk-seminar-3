package org.example.lection3_generics;

// Обобщения появились в Java 1.5
//Generics обобщения работают только со ссылочными типами данных примитивы нельзя
// E элемент, entity K key V value N number T type S,U... 2й 3й 4й типы
public class Main {
    public static void main(String[] args) {
        Box b1 = new Box(20);
        Box b2 = new Box(30);
        if (b1.getObj() instanceof Integer && b2.getObj() instanceof Integer) {
            System.out.println("sum = " + ((Integer) b1.getObj() + (Integer) b2.getObj()));
        } else {
            System.out.println("The contents of teh boxes differ by type");
        }

        Box b3 = new Box("Hello, ");
        Box b4 = new Box("World");
        System.out.println((String) b3.getObj() + (String) b4.getObj());

        //пустые скобки (diamond operator) <> означает выведение типа из контекста
        GBox<String> stringGBox = new GBox<>("Hello");
        stringGBox.printInfo();

        GBox<Integer> integerGBox = new GBox<>(12);
        integerGBox.printInfo();

        //Пример параметризированного типа
        GBox<Double> doubleGBox;

        //Raw use of generic class method getValue returns Object
        GBox gBox = new GBox("String");

        //Допускается присвавивать параметризированный тип своему сырому типу так и наоборот
        GBox box = integerGBox;

        //javac -Xlint:unchecked src/main/java/org/example/lection3/Main.java

        //Работа с обобщенным методом
        System.out.println(integerGBox.getValue());
        integerGBox.setValue(null);
        integerGBox.setIfNull(integerGBox, 13);
        System.out.println(integerGBox.getValue());

        //Bounded type parameters - позволяют ограничивать типы данных, которые могут быть использованы в качестве параметров
        // private static class BBox<V extends Number> {} - ограничение сверху
        // private static class BBox<V super Number> {} - ограничение снизу

        class Bird {
        }
        interface Man {
        }
        interface Animal {
        }
        // Пример задания нескльких гарниц (максимум одни класс и он указываетя первым и несколько интерфейсов)
        class CBox<T extends Bird & Animal & Man> {

        }

        // Связь - является is a
        Object someObject;
        Integer someInteger = Integer.valueOf(2333);
        someObject = someInteger;
        System.out.println(someObject);

        //Наследование не работает в generics Java так как работате в обычной Java
        boxTest(new GBox<Number>(10));

        //Так не получится:
        //boxTest(new GBox<Integer>(10));
        //boxTest(new GBox<Float>(10f));

        //А так получится:
        boxTest2(new GBox<Integer>(10));
        boxTest2(new GBox<Float>(10f));
    }

    private static void boxTest(GBox<Number> n) {
        System.out.println(n.getValue());
    }

    private static void boxTest2(GBox<? extends Number> n) {
        System.out.println(n.getValue());

    }
}