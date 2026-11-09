package com.bridgelabz.employeepayroll;

import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.service.EmployeePayrollService;

public class EmployeePayrollMain {
    public static void main(String[] args) {
        // Obtain Singleton instance
        EmployeePayrollService service = EmployeePayrollService.getInstance();

        System.out.println("--- Fetching All Employee Records ---");
        service.readEmployeePayrollData().forEach(System.out::println);

        System.out.println("\n--- Fetching Employee Payroll Data by Name 'Terisa' (Refactor UC 4) ---");
        EmployeePayrollData terisa = service.getEmployeePayrollDataByName("Terisa");
        if (terisa != null) {
            System.out.println("Found: " + terisa);
        } else {
            System.out.println("Employee not found.");
        }
    }
}