package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.exception.EmployeePayrollException;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollRepository {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = System.getenv("DB_PASSWORD");

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new EmployeePayrollException("Database connection failed!", e);
        }
    }

    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM employee_payroll";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                Date start = rs.getDate("start");

                EmployeePayrollData emp = new EmployeePayrollData(
                        id,
                        name,
                        salary,
                        start != null ? start.toLocalDate() : null
                );
                employeeList.add(emp);
            }
        } catch (SQLException e) {
            throw new EmployeePayrollException("Error while reading employee payroll data from database", e);
        }
        return employeeList;
    }
    public int updateEmployeeSalary(String name, double salary) {
        String sql = "UPDATE employee_payroll SET salary = ? WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, salary);
            pstmt.setString(2, name);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected;

        } catch (SQLException e) {
            throw new EmployeePayrollException("Error updating employee salary: " + e.getMessage(), e);
        }
    }
}