package com.bridgelabz.employeepayroll;

import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.service.EmployeePayrollService;

import java.time.LocalDate;

public class EmployeePayrollMain {
    public static void main(String[] args) {
        EmployeePayrollService service = EmployeePayrollService.getInstance();

        System.out.println("--- All Employee Records ---");
        service.readEmployeePayrollData().forEach(System.out::println);

        System.out.println("\n--- Retrieving Employees Joined Between 2018-01-01 and Today (UC 5) ---");
        service.getEmployeesForDateRange(LocalDate.of(2018, 01, 01), LocalDate.now())
                .forEach(System.out::println);
    }
}