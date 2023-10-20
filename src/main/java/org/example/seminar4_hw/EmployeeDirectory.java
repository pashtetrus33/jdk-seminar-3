package org.example.seminar4_hw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDirectory {

    List<Employee> employeeList;

    public EmployeeDirectory(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public EmployeeDirectory() {
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> searchByExperience(int experience) {
        return employeeList.stream().filter(employee -> employee.getExperience() == experience).collect(Collectors.toList());
    }

    public Employee searchByTabelNumber(int searchNumber) {

        return employeeList.stream().filter(employee -> employee.getTabelNumber() == searchNumber).findFirst().orElse(null);
    }

    public void printSearchByTabelNumber(int searchNumber) {
        System.out.println("---------------SEARCH BY TABELNUMBER: " + searchNumber + " ----------------------------------------------------------------------------");
        Employee foundByTabelNumber = searchByTabelNumber(searchNumber);
        if (foundByTabelNumber != null) {
            System.out.println(foundByTabelNumber);
        } else {
            System.out.println("Tabel number is not found");
        }
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public void printSearchByExperience(int experience) {
        System.out.println("---------------SEARCH BY EXPERIENCE: " + experience + " ----------------------------------------------------------------------------");
        var foundNames = searchByExperience(experience);
        if (foundNames.isEmpty()){
            System.out.println("Employees with experience " + experience + " are not exists");
        } else {
            foundNames.forEach(System.out::println);
        }
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public void printPhoneByName(String name) {
        System.out.println("---------------------PRINT TELEPHONES BY NAME " + name.toUpperCase() + " -------------------------------------------");
        //employeeList.stream().filter(employee -> employee.getName().equals(name)).forEach(employee -> System.out.println(name + ": " + employee.getPhone()));
        var foundNames = employeeList.stream().filter(employee -> employee.getName().equals(name)).toList();
        if (foundNames.isEmpty()) {
            System.out.println("Name is not found");
        } else {
            System.out.println(foundNames.stream().map(Employee::getPhone).toList());
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public void add(String name, LocalDate employmentDate, String phone) {

        employeeList.add(new Employee(name, employmentDate, phone));
        System.out.println("Successfully added employee: " + name);
    }

    public void printAll() {
        System.out.println("_______________________EMPLOYEES___________________________________");
        employeeList.stream().forEach(System.out::println);
        System.out.println("_______________________END___________________________________");
    }
}
