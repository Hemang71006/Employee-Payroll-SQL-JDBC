/**
 * Employee Payroll System SQL
 * UC9: Ability to represent employee payroll with Basic Pay, Deductions, Taxable Pay, Income Tax, Net Pay
 *
 * Author : Hemang
 * Date   : 26-10-2026
 */

USE payroll_service;
GO

-- Rename salary column to basic_pay or add payroll calculation columns
ALTER TABLE employee_payroll RENAME COLUMN salary TO basic_pay;
GO

-- Add deduction, taxable_pay, income_tax, and net_pay columns
ALTER TABLE employee_payroll ADD COLUMN deductions DOUBLE NOT NULL AFTER basic_pay;
ALTER TABLE employee_payroll ADD COLUMN taxable_pay DOUBLE NOT NULL AFTER deductions;
ALTER TABLE employee_payroll ADD COLUMN income_tax DOUBLE NOT NULL AFTER taxable_pay;
ALTER TABLE employee_payroll ADD COLUMN net_pay DOUBLE NOT NULL AFTER income_tax;
GO

-- Update records with calculated payroll details
UPDATE employee_payroll SET deductions = 50000.00, taxable_pay = basic_pay - 50000.00, income_tax = 20000.00, net_pay = (basic_pay - 50000.00) - 20000.00;
GO

-- Verify updated table data
SELECT * FROM employee_payroll;
GO