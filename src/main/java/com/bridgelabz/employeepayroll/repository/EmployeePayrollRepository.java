package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.exception.EmployeePayrollException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class EmployeePayrollRepository {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = System.getenv("DB_PASSWORD");

    public Connection connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new EmployeePayrollException("Cannot find the driver in the classpath!", e);
        }

        listDrivers();

        try {
            System.out.println("Connecting to database: " + JDBC_URL);
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("Connection is successful!!!!!! " + connection);
            return connection;
        } catch (SQLException e) {
            throw new EmployeePayrollException("Database connection failed!", e);
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }
}
