package com.bridgelabz.employeepayroll;

import com.bridgelabz.employeepayroll.repository.EmployeePayrollRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class EmployeePayrollMain {
    public static void main(String[] args) {
        EmployeePayrollRepository repository = new EmployeePayrollRepository();

        System.out.println("--- Testing Database Connectivity (UC 1) ---");
        try (Connection conn = repository.connectToDatabase()) {
            if (conn != null) {
                System.out.println("Database connection verified and closed safely.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
