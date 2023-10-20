package org.example.seminar4;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//Task3
// Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
// Найдите человека с самым маленьким номером телефона
// Найдите номер телефона человека чье имя самое большое в алфавитном порядке
public class PhoneMap {
    public static void main(String[] args) {
        Map<Integer, String> pages = new HashMap<>();

        pages.put(240, "Pavel");
        pages.put(123, "Mariia");
        pages.put(340, "Nikita");
        pages.put(50, "Olga");
        pages.put(333, "Semen");
        pages.put(11, "John");


        System.out.println(pages.entrySet().stream().min(Map.Entry.comparingByKey()).get());

        System.out.println(pages.entrySet().stream().max(Comparator.comparing(e -> e.getValue().length())).get());
    }
}
