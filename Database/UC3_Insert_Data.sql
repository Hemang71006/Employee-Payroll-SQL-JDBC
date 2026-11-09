/**
 * Employee Payroll System SQL
 * UC3: Ability to create employee payroll data in the payroll service database
 *
 * Author : Hemang
 * Date   : 26-10-2026
 */

-- Select the payroll database
USE payroll_service;
GO

-- Insert employee records into employee_payroll table
INSERT INTO employee_payroll (name, salary, start) VALUES
('Bill', 1000000.00, '2018-01-03'),
('Mark', 2000000.00, '2019-11-13'),
('Charlie', 3000000.00, '2020-05-21');
GO

-- Verify inserted records
SELECT * FROM employee_payroll;
GO