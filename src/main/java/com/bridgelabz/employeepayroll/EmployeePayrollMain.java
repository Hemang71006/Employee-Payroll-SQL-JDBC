package com.bridgelabz.employeepayroll;

import com.bridgelabz.employeepayroll.service.EmployeePayrollService;

public class EmployeePayrollMain {
    public static void main(String[] args) {
        EmployeePayrollService service = EmployeePayrollService.getInstance();

        System.out.println("--- All Employee Records ---");
        service.readEmployeePayrollData().forEach(System.out::println);

        // Run UC 6 Aggregate Functions grouped by gender
        service.printSalaryStatisticsByGender();
    }
}