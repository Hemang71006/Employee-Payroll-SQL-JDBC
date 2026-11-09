/**
 * Employee Payroll System SQL
 * UC1: Ability to create a payroll service database
 *
 * Author : Hemang
 * Date   : 26-10-2026
 */

-- Show existing databases
SHOW DATABASES;
GO

-- Create the payroll_service database
CREATE DATABASE payroll_service;
GO

-- Switch to the payroll_service database
USE payroll_service;
GO

-- Verify current database selection
SELECT DATABASE();
GO