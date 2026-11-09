/**
 * Employee Payroll System SQL
 * UC11: Ability to create normalized tables to remove redundancy
 *
 * Author : Hemang
 * Date   : 26-10-2026
 */

USE payroll_service;
GO

-- 1. Drop existing tables in reverse order of dependencies to avoid foreign key errors
DROP TABLE IF EXISTS employee_department;
DROP TABLE IF EXISTS payroll;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS company;
GO

-- 2. Create Company Table
CREATE TABLE company (
    company_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    company_name VARCHAR(100) NOT NULL,
    location VARCHAR(250),
    PRIMARY KEY (company_id)
);
GO

-- 3. Create Department Table
CREATE TABLE department (
    dept_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    dept_name VARCHAR(100) NOT NULL UNIQUE, -- Assuming department names are unique
    PRIMARY KEY (dept_id)
);
GO

-- 4. Create Employee Table (1-to-Many relationship with Company)
CREATE TABLE employee (
    emp_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    company_id INT UNSIGNED NOT NULL,
    name VARCHAR(150) NOT NULL,
    phone VARCHAR(15),
    address VARCHAR(250),
    start_date DATE NOT NULL,
    gender CHAR(1),
    PRIMARY KEY (emp_id),
    FOREIGN KEY (company_id) REFERENCES company(company_id)
);
GO

-- 5. Create Employee-Department Mapping Table (Many-to-Many relationship resolved)
CREATE TABLE employee_department (
    emp_id INT UNSIGNED NOT NULL,
    dept_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (emp_id, dept_id), -- Composite Primary Key
    FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);
GO

-- 6. Create Payroll Table (1-to-1 relationship with Employee)
CREATE TABLE payroll (
    emp_id INT UNSIGNED NOT NULL,
    basic_pay DOUBLE NOT NULL,
    deductions DOUBLE NOT NULL DEFAULT 0,
    taxable_pay DOUBLE NOT NULL DEFAULT 0,
    income_tax DOUBLE NOT NULL DEFAULT 0,
    net_pay DOUBLE NOT NULL DEFAULT 0,
    PRIMARY KEY (emp_id),
    FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
);
GO

-- Describe the new tables to verify structure
DESCRIBE company;
DESCRIBE department;
DESCRIBE employee;
DESCRIBE employee_department;
DESCRIBE payroll;
GO