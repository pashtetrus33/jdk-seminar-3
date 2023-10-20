package org.example.seminar4_hw;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
//        Табельный номер
//        Номер телефона
//        Имя
//        Стаж
//        Добавить метод, который ищет сотрудника по стажу (может быть список)
//        Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
//        Добавить метод, который ищет сотрудника по табельному номеру
//        Добавить метод добавление нового сотрудника в справочник сотрудников
public class Main {

    public static void main(String[] args) {
        EmployeeDirectory employeeDirectory = new EmployeeDirectory(new ArrayList<>(List.of(
                new Employee("Ivan", LocalDate.now(), "+7-960-344-77-55"),
                new Employee("Mariia", LocalDate.of(2020, 1, 8), "+7-960-344-77-44"),
                new Employee("Ivan", LocalDate.of(2019, 4, 15), "+7-960-344-77-78"),
                new Employee("Olga", LocalDate.of(2019, 12, 25), "+7-960-344-77-78"),
                new Employee("John", LocalDate.parse("2015-04-18"), "+7-960-344-77-00"),
                new Employee("Pavel", LocalDate.parse("2010-11-28"), "+7-960-344-02-43"))));


        employeeDirectory.printSearchByExperience(4);
        employeeDirectory.printSearchByExperience(25);

        employeeDirectory.printSearchByTabelNumber(105);
        employeeDirectory.printSearchByTabelNumber(405);


        employeeDirectory.printPhoneByName("Ivan");
        employeeDirectory.printPhoneByName("Robert");

        employeeDirectory.add("John", LocalDate.parse("2015-04-18"), "+7-960-456-14-99");

        employeeDirectory.printAll();
    }
}
