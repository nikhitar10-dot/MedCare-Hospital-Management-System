# MedCare – Hospital Management System

A console-based Hospital Management System developed using Java, MySQL, JDBC, and Object-Oriented Programming (OOP) concepts.

The application helps manage hospital operations, including patient registration, doctor management, appointment scheduling, billing, and hospital financial statistics.

## Project Information

- **Project Title:** MedCare – Hospital Management System
- **Programming Language:** Java
- **Database:** MySQL
- **Database Connectivity:** JDBC
- **IDE:** Visual Studio Code
- **Application Type:** Console-Based Application
- **Project Type:** Academic Mini-Project

## Features

### 1. Patient Management
- Register new patients.
- View all registered patients.
- Search for patients using their ID.
- Update patient information.
- Delete patient records.

### 2. Doctor Management
- Register doctors with their specialization and department.
- Store doctor consultation fees and monthly salaries.
- View all registered doctors.
- Search for doctors using their ID.
- Delete doctor records.

### 3. Appointment Management
- Book appointments for registered patients.
- View appointment details.
- Update appointment status.
- Delete appointments.

### 4. Billing Management
- Generate bills using consultation and medicine fees.
- Calculate the total bill amount.
- Apply percentage-based discounts.
- View generated bills.

### 5. Hospital Statistics
- Display the total number of patients.
- Display the total number of doctors.
- Display the total number of appointments.
- Calculate total recorded billing revenue.
- Calculate total doctor salaries.
- Estimate hospital profit or loss.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application development |
| MySQL | Storing hospital records |
| JDBC | Connecting Java with MySQL |
| Visual Studio Code | Writing and running Java code |
| MySQL Connector/J | JDBC driver for MySQL connectivity |

## Object-Oriented Programming Concepts

The project demonstrates the following Java concepts:

- **Classes and Objects:** Represent hospital entities such as patients, doctors, appointments, and bills.
- **Encapsulation:** Private fields with getters and setters protect object data.
- **Inheritance:** The `Patient` and `Doctor` classes inherit from the abstract `Person` class.
- **Abstraction:** The `Person` class defines an abstract method.
- **Interfaces:** The `Billable` interface defines the billing operation.
- **Polymorphism:** Method overriding and runtime dynamic binding are demonstrated.
- **Method Overloading:** Multiple methods with the same name use different parameter lists.
- **Constructor Overloading:** Classes support different ways of creating objects.
- **`this` Keyword:** Refers to the current object.
- **`super` Keyword:** Accesses parent-class constructors and methods.
- **Static Members:** Shared fields and methods manage common information.
- **Final Members:** Constants are declared using the `final` keyword.
- **Enums:** The `Department` enum represents hospital departments.
- **Arrays of Objects:** Arrays demonstrate the storage of object references.
- **Type Casting:** Explicit casting converts a numeric value to an integer.
- **Operator Precedence:** Arithmetic expressions demonstrate operator precedence.
- **Control Flow:** Conditional statements, switch statements, loops, and jump statements control program execution.
- **String Methods:** String operations process console input.
- **Method Overriding:** The `toString()` method provides readable object information.
- **Custom Packages:** The application separates model and service classes into packages.

## Project Structure

```text
HospitalManagementSystem/
│
├── lib/
│   └── mysql-connector-j-26.7.0.jar
│
├── src/
│   └── hospital/
│       ├── Main.java
│       │
│       ├── model/
│       │   ├── Person.java
│       │   ├── Patient.java
│       │   ├── Doctor.java
│       │   ├── Appointment.java
│       │   ├── Bill.java
│       │   ├── Billable.java
│       │   ├── Department.java
│       │   └── HospitalConstants.java
│       │
│       └── service/
│           ├── DatabaseConnection.java
│           ├── PatientService.java
│           ├── DoctorService.java
│           ├── AppointmentService.java
│           └── BillService.java
│
└── README.md
```

## Database Design

The application uses a MySQL database named `hospital_management`.

The database contains four main tables:

| Table | Description |
|---|---|
| `patients` | Stores patient details, including name, age, gender, phone number, blood group, and department. |
| `doctors` | Stores doctor details, specialization, department, consultation fee, and salary. |
| `appointments` | Stores appointment details, patient ID, doctor ID, appointment date, and status. |
| `bills` | Stores patient billing details, consultation fee, medicine fee, and total amount. |

Primary keys uniquely identify records, while foreign keys connect appointments and bills to the relevant patient and doctor records.

## Application Workflow

1. The application starts and establishes a connection to the MySQL database.
2. The main menu displays the available hospital management operations.
3. The user selects an operation by entering its corresponding menu number.
4. The application accepts the required information through console input.
5. The service classes execute the corresponding database operations using JDBC.
6. The application displays the operation result and returns to the main menu.
7. The user can exit the application using the exit option.

## Conclusion

The MedCare Hospital Management System demonstrates how Java programming and MySQL database connectivity can be used to develop a console-based application for managing hospital operations.

The system provides functionalities for patient registration, doctor management, appointment scheduling, billing, and hospital financial statistics. It integrates Java with MySQL through JDBC to store and retrieve hospital records.

The project also demonstrates important Object-Oriented Programming concepts, including encapsulation, inheritance, abstraction, polymorphism, interfaces, method overloading, method overriding, and constructors. The use of custom packages helps organize the source code into manageable components.

Overall, this project provides practical experience in Java programming, database management, JDBC connectivity, and the development of a real-world console-based application.

---

**Developed as an academic mini-project for Java Programming.**
