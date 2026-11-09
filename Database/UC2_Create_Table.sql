/**
 * Employee Payroll System SQL
 * UC2: Ability to create an employee payroll table in the payroll service database
 *
 * Author : Hemang
 * Date   : 26-10-2026
 */

-- Select the payroll database
USE payroll_service;
GO

-- Drop table if it already exists to avoid conflicts during testing
DROP TABLE IF EXISTS employee_payroll;
GO

-- Create employee_payroll table with id, name, salary, and start date
CREATE TABLE employee_payroll (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    salary DOUBLE NOT NULL,
    start DATE NOT NULL,
    PRIMARY KEY (id)
);
GO

-- Describe table structure to verify columns and data types
DESCRIBE employee_payroll;
GO