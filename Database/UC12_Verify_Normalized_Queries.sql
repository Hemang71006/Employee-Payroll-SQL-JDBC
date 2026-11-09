/**
 * Employee Payroll System SQL
 * UC12: Ability to perform retrieval queries and verify normalized schema
 *
 * Author : Hemang
 * Date   : 26-10-2026
 */

USE payroll_service;
GO

-- --- Part 1: Populate Normalized Tables with Sample Data --- --

-- Insert Company Data
INSERT INTO company (company_name, location) VALUES
('BridgeLabz Solutions', 'Mumbai'),
('TechCorp Inc.', 'Bangalore');
GO

-- Insert Department Data
INSERT INTO department (dept_name) VALUES
('Sales'),
('Marketing'),
('HR'),
('Engineering');
GO

-- Insert Employee Data (referencing company_id)
-- Assuming BridgeLabz is Company ID 1
INSERT INTO employee (company_id, name, phone, address, start_date, gender) VALUES
(1, 'Bill', '9876543210', '101, MG Road, Mumbai', '2018-01-03', 'M'),
(1, 'Terisa', '9876543211', 'B-301, Andheri, Mumbai', '2019-11-13', 'F'),
(1, 'Charlie', '9876543212', '55, Dadar, Mumbai', '2020-05-21', 'M'),
(2, 'Mark', '9123456780', '404, Koramangala, Bangalore', '2021-07-10', 'M');
GO

-- Insert Payroll Data (referencing emp_id)
INSERT INTO payroll (emp_id, basic_pay, deductions, taxable_pay, income_tax, net_pay) VALUES
(1, 1000000.00, 50000.00, 950000.00, 200000.00, 750000.00),
(2, 2000000.00, 100000.00, 1900000.00, 400000.00, 1500000.00),
(3, 3000000.00, 150000.00, 2850000.00, 600000.00, 2250000.00),
(4, 2500000.00, 120000.00, 2380000.00, 500000.00, 1880000.00);
GO

-- Insert Employee-Department Relationships
INSERT INTO employee_department (emp_id, dept_id) VALUES
(1, 1), -- Bill in Sales
(2, 2), -- Terisa in Marketing
(2, 3), -- Terisa also in HR (simulating multi-department assignment if needed)
(3, 4), -- Charlie in Engineering
(4, 4); -- Mark in Engineering
GO

-- --- Part 2: Verification Queries (Re-implementing UC 4, 5, 7) --- --

-- UC 4: Retrieve all employee data (Joined with Company, Payroll, and Departments)
SELECT
    e.emp_id, e.name, e.gender, e.start_date,
    c.company_name, c.location,
    p.basic_pay, p.net_pay,
    GROUP_CONCAT(d.dept_name SEPARATOR ', ') AS departments
FROM employee e
JOIN company c ON e.company_id = c.company_id
JOIN payroll p ON e.emp_id = p.emp_id
JOIN employee_department ed ON e.emp_id = ed.emp_id
JOIN department d ON ed.dept_id = d.dept_id
GROUP BY e.emp_id, c.company_id, p.emp_id;
GO

-- UC 5: Retrieve salary for a specific employee (e.g., 'Bill')
SELECT
    e.name, p.net_pay
FROM employee e
JOIN payroll p ON e.emp_id = p.emp_id
WHERE e.name = 'Bill';
GO

-- UC 5: Retrieve employees who joined in a particular date range
SELECT
    name, start_date
FROM employee
WHERE start_date BETWEEN CAST('2019-01-01' AS DATE) AND DATE(NOW());
GO

-- UC 7: Aggregate statistical queries on normalized tables (Sum, Avg, Min, Max, Count)
SELECT
    e.gender,
    SUM(p.net_pay) AS total_net_pay,
    AVG(p.net_pay) AS average_net_pay,
    MIN(p.net_pay) AS minimum_net_pay,
    MAX(p.net_pay) AS maximum_net_pay,
    COUNT(e.emp_id) AS employee_count
FROM employee e
JOIN payroll p ON e.emp_id = p.emp_id
GROUP BY e.gender;
GO