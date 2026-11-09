/**
 * Employee Payroll System SQL
 * UC5: Ability to retrieve salary for a particular employee or within a date range
 *
 * Author : Hemang
 * Date   : 26-10-2026
 */

-- Select the payroll database
USE payroll_service;
GO

-- Retrieve salary for a specific employee (e.g., 'Bill')
SELECT salary FROM employee_payroll WHERE name = 'Bill';
GO

-- Retrieve employees who joined between a specific date range using CAST and NOW/dates
SELECT * FROM employee_payroll
WHERE start BETWEEN CAST('2019-01-01' AS DATE) AND DATE(NOW());
GO