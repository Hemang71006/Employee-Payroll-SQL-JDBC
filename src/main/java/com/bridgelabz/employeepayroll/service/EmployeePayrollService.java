package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.repository.EmployeePayrollRepository;

import java.util.List;

public class EmployeePayrollService {
    private final EmployeePayrollRepository repository = new EmployeePayrollRepository();

    public List<EmployeePayrollData> readEmployeePayrollData() {
        return repository.getEmployeePayrollData();
    }

    public boolean updateEmployeeSalary(String name, double salary) {
        int rowsUpdated = repository.updateEmployeeSalary(name, salary);
        return rowsUpdated > 0;
    }
}