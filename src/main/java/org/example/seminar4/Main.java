package org.example.seminar4;


import java.util.*;
//Task1
//Создайте коллекцию мужских и женских имен с помощью интерфейса List
//Отсортируйте коллекцию в алфавитном порядке
//Отсортируйте коллекцию по количеству букв в слове
//Разверните коллекцию

//Task2
//Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
//        Получите уникальный список Set на основании List
//        Определите наименьший элемент (алфавитный порядок)
//        Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
//        Удалите все элементы содержащие букву ‘A’





public class Main {
    public static void main(String[] args) {

        List<String> namesList = new ArrayList<>();
        namesList.add("Mariia");
        namesList.add("Daria");
        namesList.add("Daria");
        namesList.add("Daria");
        namesList.add("Ivan");
        namesList.add("Ivan");
        namesList.add("Yan");
        namesList.add("Vladimir");
        namesList.add("Roman");
        System.out.println("----------------------Task1--------------------------------------------------------");
        System.out.println(namesList);

        Collections.sort(namesList);

        System.out.println(namesList);

        Collections.reverse(namesList);
        System.out.println(namesList);

        namesList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        System.out.println(namesList);
        System.out.println("----------------------Task2--------------------------------------------------------");

        //        Получите уникальный список Set на основании List
        Set<String> namesSet = new HashSet<>(namesList);
        System.out.println(namesSet);

        //Определите наименьший элемент (алфавитный порядок)
        System.out.println(namesSet.stream().sorted().findFirst().get());
        //min(Comparator.naturalOrder());

        //Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
        System.out.println(namesSet.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        }).findFirst().get());


        //        Удалите все элементы содержащие букву ‘A’

        namesList.removeIf(item -> item.toLowerCase().contains("a"));
        System.out.println(namesList);

    }
}
