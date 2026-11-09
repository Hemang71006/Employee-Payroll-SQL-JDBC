package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.repository.EmployeePayrollRepository;

import java.util.List;

public class EmployeePayrollService {
    private static EmployeePayrollService instance;
    private final EmployeePayrollRepository repository;

    private EmployeePayrollService() {
        this.repository = new EmployeePayrollRepository();
    }

    // Singleton instance method
    public static synchronized EmployeePayrollService getInstance() {
        if (instance == null) {
            instance = new EmployeePayrollService();
        }
        return instance;
    }

    public List<EmployeePayrollData> readEmployeePayrollData() {
        return repository.getEmployeePayrollData();
    }

    public EmployeePayrollData getEmployeePayrollDataByName(String name) {
        return repository.getEmployeePayrollDataByName(name);
    }

    public boolean updateEmployeeSalary(String name, double salary) {
        int rowsUpdated = repository.updateEmployeeSalary(name, salary);
        return rowsUpdated > 0;
    }
}