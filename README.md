# Employee Payroll Application - Core Java, MySQL & JDBC

A robust, production-grade Java application implementing an Employee Payroll System following a clean layered architecture (`model`, `repository`, `service`, `exception`, and main runner) with secure credential management and a strict Git feature-branch workflow.

---

## 📂 Project Directory Structure

```text
Employee-Payroll-SQL-JDBC/
│
└── src/
    └── main/
        └── java/
            └── com/
                └── bridgelabz/
                    └── employeepayroll/
                        │
                        ├── EmployeePayrollMain.java        # Main runner application
                        ├── exception/
                        │   └── EmployeePayrollException.java # Custom runtime exception handling
                        ├── model/
                        │   └── EmployeePayrollData.java    # Entity model class with date support
                        ├── repository/
                        │   └── EmployeePayrollRepository.java # Database connection, SQL queries & PreparedStatements
                        └── service/
                            └── EmployeePayrollService.java # Singleton business logic service layer

```

---

## 🏗️ Architecture & Design Pattern

* **Layered Architecture:**
* `model`: Contains entity classes (`EmployeePayrollData`) with support for dates and backward compatibility.
* `repository`: Manages database connectivity, raw SQL execution, and `PreparedStatement` caching.
* `service`: Encapsulates business logic, implemented as a **Singleton** pattern for optimal statement and connection management.
* `exception`: Custom runtime exceptions (`EmployeePayrollException`) for robust error handling.


* **Security:** Database credentials are securely handled via environment variables (`DB_PASSWORD`).
* **Version Control:** Strict Git feature-branch workflow (`feature/jdbc-uc*`) merged sequentially into `develop`.

---

## 📌 Section 1: MySQL Database & Basic CRUD (UC 1 - UC 7)

* **UC 1:** Created the `payroll_service` database using MySQL client.
* **UC 2:** Created the `employee_payroll` table with `id` (unsigned INT, primary key, auto-increment), `name` (`VARCHAR(150)`, NOT NULL), `salary` (`DOUBLE`, NOT NULL), and `start` (`DATE`, NOT NULL).
* **UC 3:** Inserted sample employee payroll test data (`Bill`, `Mark`, `Charlie`).
* **UC 4:** Retrieved all employee payroll rows and records using `SELECT * FROM employee_payroll`.
* **UC 5:** Retrieved specific employee salary data using `WHERE name = 'Bill'` and filtered records within date boundaries using `WHERE start BETWEEN CAST('2018-01-01' AS DATE) AND DATE(NOW())`.
* **UC 6:** Added a `gender` field via `ALTER TABLE employee_payroll ADD gender CHAR(1) AFTER name;` and updated specific records.
* **UC 7:** Performed data analysis using SQL analytical aggregate functions (`SUM`, `AVG`, `MIN`, `MAX`, `COUNT`) grouped by `gender`.

---

## 📌 Section 2: Normalization, ER Modeling & Advanced Schema (UC 8 - UC 12)

* **UC 8:** Extended table schema to store supplementary attributes including employee `phone_number`, `address`, and department fields.
* **UC 9:** Expanded financial attributes to support detailed payroll breakdowns: `basic_pay`, `deductions`, `taxable_pay`, `income_tax`, and `net_pay`.
* **UC 10:** Addressed database redundancy challenges (e.g., updating multi-row records for duplicate names like Terisa) by identifying composite and multi-valued attributes.
* **UC 11:** Implemented a fully normalized ER Diagram architecture, splitting monolithic tables into discrete entities: `Company`, `Employee`, `Payroll`, `Department`, and mapping table `Employee_Department` for Many-to-Many relationships.
* **UC 12:** Refactored and verified legacy data retrieval queries to run seamlessly against the new normalized relational schema structure.

---

## 📌 Section 3: Java JDBC Implementation (UC 1 - UC 6)

* **UC 1:** Programmatically loaded the MySQL Connector/J driver (`com.mysql.cj.jdbc.Driver`), registered/listed active drivers, and established a secure connection using `DriverManager` with environment credentials.
* **UC 2:** Implemented data retrieval logic to read all employee records from the database into typed collection lists (`List<EmployeePayrollData>`), mapping SQL dates to `LocalDate` with custom exception wrapping.
* **UC 3:** Implemented database synchronization and update queries to modify employee Terisa's base salary to `3,000,000.00`.
* **Refactor UC 4:** Re-architected data retrieval using parameterized `PreparedStatement` objects, cached statement execution handles at the driver/DB level, applied the **Singleton** pattern to `EmployeePayrollService`, and optimized `ResultSet` mapping reuse.
* **UC 5:** Developed date-range filtering functionality within the repository layer to query employees based on joining windows using SQL `CAST` conversions.
* **UC 6:** Programmatically executed and formatted aggregate SQL queries (`SUM`, `AVG`, `MIN`, `MAX`, `COUNT` grouped by `gender`) from the Java application runtime.

---

## ⚙️ Environment Setup & Execution Guide

### 1. Prerequisites

* Java Development Kit (JDK 17 or higher)
* MySQL Server (v8.0+)
* MySQL JDBC Driver (`mysql-connector-j`) added to project dependencies / build path.

### 2. Configure Environment Variables

Set your local MySQL root password as an environment variable in your terminal before launching the application:

```powershell
# Windows PowerShell
$env:DB_PASSWORD="your_mysql_secure_password"

```

```bash
# Linux / macOS
export DB_PASSWORD="your_mysql_secure_password"

```

### 3. Build and Run

Compile and run `EmployeePayrollMain.java` using your preferred IDE (Eclipse, IntelliJ IDEA) or build tools:

```powershell
mvn clean compile exec:java -Dexec.mainClass="com.bridgelabz.employeepayroll.EmployeePayrollMain"

```

```bash
gradle run

```

```

```