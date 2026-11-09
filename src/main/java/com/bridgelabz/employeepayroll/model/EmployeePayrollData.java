package com.bridgelabz.employeepayroll.model;

import java.time.LocalDate;

public class EmployeePayrollData {
    private int id;
    private String name;
    private double salary;
    private LocalDate startDate;

    // Constructor for backward compatibility / general use
    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public EmployeePayrollData(int id, String name, double salary, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Start Date: " + startDate;
    }
}
