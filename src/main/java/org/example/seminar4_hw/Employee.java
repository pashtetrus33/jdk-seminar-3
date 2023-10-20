package org.example.seminar4_hw;

import java.time.LocalDate;

public class Employee {

    private static int counter = 100;
    private int tabelNumber;
    private String name;

    private LocalDate employmentDate;
    private int experience;
    private String phone;

    {
        tabelNumber = ++counter;
    }

    public Employee(String name, LocalDate employmentDate, String phone) {
        this.employmentDate = employmentDate;
        this.name = name;
        this.experience = LocalDate.now().getYear() - employmentDate.getYear();
        this.phone = phone;
    }

    public int getTabelNumber() {
        return tabelNumber;
    }

    public void setTabelNumber(int tabelNumber) {
        this.tabelNumber = tabelNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "tabelNumber=" + tabelNumber +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", phone='" + phone + '\'' +
                '}';
    }
}
