/**
 * Employee Payroll System SQL
 * UC6: Ability to add gender to employee payroll table and update records
 *
 * Author : Hemang
 * Date   : 26-10-2026
 */

USE payroll_service;
GO

-- Add gender column to employee_payroll table
ALTER TABLE employee_payroll ADD COLUMN gender CHAR(1) AFTER name;
GO

-- Update gender for existing employees
UPDATE employee_payroll SET gender = 'M' WHERE name = 'Bill' OR name = 'Charlie';
UPDATE employee_payroll SET gender = 'M' WHERE name = 'Mark';

-- Update a specific employee's salary and test update condition
UPDATE employee_payroll SET salary = 3000000.00 WHERE name = 'Terisa';
GO

-- Verify table data
SELECT * FROM employee_payroll;
GO