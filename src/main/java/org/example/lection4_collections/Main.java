package org.example.lection4_collections;

import org.example.lection4_collections.linklist.LinkList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Collection<Integer> collection = List.of(1, 2, 3, 4);
        System.out.println("-----------------------------Variant1-------------------------------");
        //foreach
        for (Integer element : collection) {
            System.out.print(element + " ");
        }
        System.out.println("\n-----------------------------Variant2-------------------------------");
        Iterator<Integer> iterator = collection.iterator();
        //iterator
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n-----------------------------Variant3-------------------------------");
        //Stream api lambda
        collection.stream().forEach(v -> System.out.print(v + " "));
        System.out.println("\n-----------------------------Variant4-------------------------------");
        //steams method reference
        collection.forEach(System.out::print);
        System.out.println("\n--------------------------------------------------------------------");

        //Реализация интерфейса List
        ArrayList<Integer> list = new ArrayList<>(collection);
        System.out.println("\n--------------------------My LinkList------------------------------------------");
        LinkList<String> myStringList = new LinkList<>();
        myStringList.add("Hello");
        myStringList.add("World");
        myStringList.add("and");
        myStringList.add("Everybody");
        for (String s : myStringList) {
            System.out.println(s);
        }
    }
}
