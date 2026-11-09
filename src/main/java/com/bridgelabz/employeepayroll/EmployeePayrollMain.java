package com.bridgelabz.employeepayroll;

import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.service.EmployeePayrollService;

import java.util.List;

public class EmployeePayrollMain {
    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();

        System.out.println("--- Retrieving Employee Payroll Data (UC 2) ---");
        List<EmployeePayrollData> employeePayrollData = service.readEmployeePayrollData();
        employeePayrollData.forEach(System.out::println);
    }
}