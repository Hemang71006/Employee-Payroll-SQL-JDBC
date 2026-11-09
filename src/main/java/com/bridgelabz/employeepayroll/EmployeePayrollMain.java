package com.bridgelabz.employeepayroll;

import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.service.EmployeePayrollService;

import java.util.List;

public class EmployeePayrollMain {
    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();

        System.out.println("--- Before Salary Update ---");
        service.readEmployeePayrollData().forEach(System.out::println);

        System.out.println("\n--- Updating Terisa's Salary to 3,000,000.00 (UC 3) ---");
        boolean isUpdated = service.updateEmployeeSalary("Terisa", 3000000.00);

        if (isUpdated) {
            System.out.println("Salary updated successfully in database.");
        }

        System.out.println("\n--- After Salary Update ---");
        List<EmployeePayrollData> employees = service.readEmployeePayrollData();
        employees.forEach(System.out::println);
    }
}