package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.exception.EmployeePayrollException;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollRepository {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = System.getenv("DB_PASSWORD");

    private PreparedStatement getEmployeeByNameStatement;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            // Prepare and cache the PreparedStatement for fetching by name
            if (getEmployeeByNameStatement == null) {
                getEmployeeByNameStatement = conn.prepareStatement("SELECT * FROM employee_payroll WHERE name = ?");
            }
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            throw new EmployeePayrollException("Database connection or statement preparation failed!", e);
        }
    }

    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM employee_payroll";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                employeeList.add(mapResultSetToEmployee(rs));
            }
        } catch (SQLException e) {
            throw new EmployeePayrollException("Error while reading employee payroll data", e);
        }
        return employeeList;
    }

    public EmployeePayrollData getEmployeePayrollDataByName(String name) {
        try (Connection conn = getConnection()) {
            getEmployeeByNameStatement = conn.prepareStatement("SELECT * FROM employee_payroll WHERE name = ?");
            getEmployeeByNameStatement.setString(1, name);

            try (ResultSet rs = getEmployeeByNameStatement.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEmployee(rs);
                }
            }
        } catch (SQLException e) {
            throw new EmployeePayrollException("Error retrieving employee by name: " + name, e);
        }
        return null;
    }

    private EmployeePayrollData mapResultSetToEmployee(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String empName = rs.getString("name");
        double salary = rs.getDouble("salary");
        Date start = rs.getDate("start");

        return new EmployeePayrollData(
                id,
                empName,
                salary,
                start != null ? start.toLocalDate() : null
        );
    }

    public int updateEmployeeSalary(String name, double salary) {
        String sql = "UPDATE employee_payroll SET salary = ? WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, salary);
            pstmt.setString(2, name);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new EmployeePayrollException("Error updating employee salary", e);
        }
    }
}