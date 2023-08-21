# HR-Department-Management-System-Rest-API
The HR Department Management System is a Spring Boot application that provides functionalities to manage employee information, attendance records, department details, positions, and salaries within an organization.

# Table of Contents
* Features
* Technologies Used
* Getting Started
* Usage
* API Endpoints
* Database Configuration
* Build and Run

# Features
* Employee Management: Add, update, retrieve, and delete employee information including name, email, phone number, address, department, 
  and position.
* Attendance Tracking: Record employee attendance with in-time and out-time stamps.
* Department Management: Manage organizational departments, including adding, updating, retrieving, and deleting department details.
* Position Management: Maintain different job positions available within the organization.
* Salary Management: Keep track of salary details for various positions, including basic salary, allowances, and gross salary 
  calculations.

# Technologies Used
* Java 8
* Spring Boot 2.7.14
* Spring Data JPA
* MySQL Database
* ModelMapper
* Lombok
* Maven

# Getting Started
* Make sure you have Java 8 or higher installed on your machine.
* Set up a MySQL database and configure the database connection in application.properties.
* Clone this repository to your local machine.
* Build and run the application using Maven.

# Usage
The HR Department Management System provides a set of API endpoints to perform various operations on employee, attendance, department, position, and salary data.

# API Endpoints

# Employee Management:

* /api/employees: GET - Retrieve a list of all employees.
* /api/employees/{id}: GET - Retrieve an employee by ID.
* /api/employees: POST - Create a new employee.
* /api/employees/{id}: PUT - Update an existing employee.
* /api/employees/{id}: DELETE - Delete an employee by ID.

# Attendance Tracking:

* /api/attendances: GET - Retrieve a list of all attendance records.
* /api/attendances/{id}: GET - Retrieve an attendance record by ID.
* /api/attendances: POST - Create a new attendance record.
* /api/attendances/{id}: PUT - Update an existing attendance record.
* /api/attendances/{id}: DELETE - Delete an attendance record by ID.

# Department Management:

* /api/departments: GET - Retrieve a list of all departments.
* /api/departments/{id}: GET - Retrieve a department by ID.
* /api/departments: POST - Create a new department.
* /api/departments/{id}: PUT - Update an existing department.
* /api/departments/{id}: DELETE - Delete a department by ID.

# Position Management:

* /api/positions: GET - Retrieve a list of all positions.
* /api/positions/{id}: GET - Retrieve a position by ID.
* /api/positions: POST - Create a new position.
* /api/positions/{id}: PUT - Update an existing position.
* /api/positions/{id}: DELETE - Delete a position by ID.

# Salary Management:

* /api/salaries: GET - Retrieve a list of all salaries.
* /api/salaries/{id}: GET - Retrieve a salary by ID.
* /api/salaries: POST - Create a new salary record.
* /api/salaries/{id}: PUT - Update an existing salary record.
* /api/salaries/{id}: DELETE - Delete a salary record by ID.

# Mysql Database Configuration
* Configure the database connection in application.properties:
* spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
* spring.datasource.username=your_database_username
* spring.datasource.password=your_database_password

# Build and Run
* Navigate to the project directory.
* Build the project using Maven: mvn clean install
* Run the application: mvn spring-boot:run
