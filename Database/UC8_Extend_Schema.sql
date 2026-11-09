/**
 * Employee Payroll System SQL
 * UC8: Ability to extend employee_payroll table to store phone, address, and department
 *
 * Author : Hemang
 * Date   : 26-10-2026
 */

USE payroll_service;
GO

-- Add phone, address, and department columns to employee_payroll table
ALTER TABLE employee_payroll ADD COLUMN phone VARCHAR(15) AFTER name;
ALTER TABLE employee_payroll ADD COLUMN address VARCHAR(250) DEFAULT 'Rest of India' AFTER phone;
ALTER TABLE employee_payroll ADD COLUMN department VARCHAR(100) NOT NULL AFTER gender;
GO

-- Update department and contact information for existing records
UPDATE employee_payroll SET department = 'Sales' WHERE name = 'Bill';
UPDATE employee_payroll SET department = 'Marketing' WHERE name = 'Mark';
UPDATE employee_payroll SET department = 'HR' WHERE name = 'Charlie';
GO

-- Verify updated table structure and data
DESCRIBE employee_payroll;
SELECT * FROM employee_payroll;
GO