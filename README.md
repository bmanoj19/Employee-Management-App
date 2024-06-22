# Employee Management System

This project consists of two Spring Boot applications designed to manage employee and department information. The Department Management application handles the details of all departments, while the main Employee Management System(EMS) application integrates with the Department Management application to manage employee details.


## Project Overview
The EMS App is designed to provide a comprehensive system for managing employee and department information. It comprises two main applications:

1. Department Management Application: Manages department details.
2. EMS Application: Manages employee details and integrates with the Department Management application to assign departments to employees.

## Features
1. Department Management Application:
Create, update, delete, and view department details.
2. EMS Application:
Create, update, delete, and view employee details.
Integrate with the Department Management application to assign departments to employees.

## Technologies Used
- Java
- Spring Boot
- MySQL (Database)
- Thymeleaf with HTML (UI)

## Files in the Repository
- Department_Management: Spring Boot application for managing department details.
- Employee_Management: Spring Boot application for managing employee details.
- Result Screenshots: Contains screenshots of the application results, including add, edit, delete, and view employee actions, and view all pages.
- README.md: This file, providing an overview and instructions for the project.

## Setup Instructions
### Prerequisites
Ensure you have the following installed on your machine:

- Java Development Kit (JDK) 8 or higher
- Maven
- MySQL Server
### Cloning the Repository
Clone the repository to your local machine using:
```
git clone https://github.com/yourusername/Employee-Management-App.git
cd Employee-Management-App
```
### Database Configuration
Both applications require a MySQL database. Update the src/main/resources/application.properties file in each project with your MySQL database details:
```
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
Create the necessary databases in MySQL before running the applications.
### Running the Applications
### Running via Command Line
Department Management Application
- Navigate to the Department_Management directory:
```
cd Department_Management
```
- Build and run the application using Maven:
```
mvn clean install
mvn spring-boot:run
```
Employee Management Application
- Navigate to the Employee_Management directory:
```
cd Employee_Management
```
- Build and run the application using Maven:
```
mvn clean install
mvn spring-boot:run
```
#### Running via IDE
You can also run the applications directly in any Java IDE such as IntelliJ IDEA, Spring Tool Suite (STS), or Eclipse.

1. Import the projects:

- Open your IDE.
- Choose "Import Project" or "Open Project" from the menu.
- Select the Department_Management and Employee_Management directories separately to import them as Maven projects.
2. Run the applications:
- For IntelliJ IDEA:
  - Right-click the main class (e.g., DepartmentManagementApplication.java or EmployeeManagementApplication.java).
  - Select "Run" from the context menu.
- For STS or Eclipse:
  - Right-click the project in the Project Explorer.
  - Select "Run As" -> "Spring Boot App" or "Java Application".

## Usage
- Access the Department Management application at http://localhost:8081.
- Access the Employee Management application at http://localhost:8080.

## Screenshots
The Result Screenshots folder contains screenshots of the following actions:

- Add Employee
- Edit Employee
- Delete Employee
- View Employee
- Employee List (Home page)

## Conclusion
The EMS App is a robust solution for managing departments and employees efficiently. Built on Spring Boot and MySQL, it offers a seamless experience for adding, editing, and viewing employee details, while also providing comprehensive department management capabilities.


