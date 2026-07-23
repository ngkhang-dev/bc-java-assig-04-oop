# Assignment 04 - Session 10 - OOP

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Status](https://img.shields.io/badge/status-completed-brightgreen)

<!-- TOC -->

* [Assignment 04 - Session 10 - OOP](#assignment-04---session-10---oop)
    * [Requirements](#requirements)
    * [Prerequisites](#prerequisites)
        * [Project Structure](#project-structure)
        * [Environment](#environment)
    * [Author](#author)

<!-- TOC -->

## Requirements

Management of employees in a company.

- **Class diagram**:

    ```mermaid
    classDiagram
        direction BT
        class Workable {
            <<interface>>
            + work() void
        }
    
        class Reportable {
            <<interface>>
            + report() void
        }
    
        class Manageable {
            <<interface>>
            + manage() void
        }
    
        class Employee {
            <<abstract>>
            # int id
            # String name
            # double salary
            # String role
            + display() void
            + displayDetailInfo()* void
            + calculateSalary()* double
        }
    
        class EmployeeManager {
            - ArrayList<Employee> employees
            + addEmployee(List<Employee> employees) void
            + displayEmployees() void
            + displaySalaries() void
            + performActions(int index) void
            + performActions(T object) void
            + performAllActions()
            - calculateSalariesByRole() Map<String, Double>
        }
    
        class Developer {
            - int experienceYears
            - String projectName
        }
    
        class Tester {
            - String testingTool;
            - int bugCount;
        }
    
        class Manager {
            - double bonus
        }
    
        class Director {
            - double stockPercent
            - String strategy
        }
    
        EmployeeManager o-- Employee
        Developer --|> Employee
        Developer ..> Workable
        Tester --|> Employee
        Tester ..> Workable
        Tester ..> Reportable
        Manager --|> Employee
        Manager ..> Workable
        Manager ..> Reportable
        Manager ..> Manageable
        Director --|> Employee
        Director ..> Reportable
        Director ..> Manageable
    ```

## Prerequisites

### Project Structure

```text
./
│   .gitignore
│   README.md
│
├───docs
│       assign-04-oop.png
│
└───src
    │   MainApplication.java
    │
    ├───interfaces
    │       Manageable.java
    │       Reportable.java
    │       Workable.java
    │
    ├───manager
    │       EmployeeManager.java
    │
    ├───model
    │       Developer.java
    │       Director.java
    │       Employee.java
    │       Manager.java
    │       Tester.java
    │
    └───util
            Util.java
```

### Environment

- IDE: IntelliJ IDEA
- JDK: 21 or higher

## Author

Khang Nguyen
