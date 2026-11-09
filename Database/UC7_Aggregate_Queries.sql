/**
 * Employee Payroll System SQL
 * UC7: Ability to find sum, average, min, max, and count of salary grouped by gender
 *
 * Author : Hemang
 * Date   : 26-10-2026
 */

USE payroll_service;
GO

-- Calculate sum of salaries grouped by gender
SELECT gender, SUM(salary) AS total_salary
FROM employee_payroll
GROUP BY gender;
GO

-- Calculate average salary grouped by gender
SELECT gender, AVG(salary) AS average_salary
FROM employee_payroll
GROUP BY gender;
GO

-- Find minimum salary grouped by gender
SELECT gender, MIN(salary) AS minimum_salary
FROM employee_payroll
GROUP BY gender;
GO

-- Find maximum salary grouped by gender
SELECT gender, MAX(salary) AS maximum_salary
FROM employee_payroll
GROUP BY gender;
GO

-- Count total number of employees grouped by gender
SELECT gender, COUNT(id) AS employee_count
FROM employee_payroll
GROUP BY gender;
GO