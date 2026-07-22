import manager.EmployeeManager;
import model.Developer;
import model.Director;
import model.Manager;
import model.Tester;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EmployeeManager employeeManager = initialData();

        System.out.print("""
                =======================================
                Welcome to Employee Application System
                =======================================
                """);

        // Display all employees
        System.out.println("All employees:");
        employeeManager.displayEmployees();
    }

    public static EmployeeManager initialData() {
        EmployeeManager employeeManager = new EmployeeManager();

        Developer dev1 = new Developer("DEV001", "John", 10_000, 3, "Project 1");
        Developer dev2 = new Developer("DEV002", "Tom", 9_000, 2, "Project 1");
        Developer dev3 = new Developer("DEV003", "Hank", 12_000, 4, "Project 2");

        Tester tester1 = new Tester("TEST001", "Jane", 8_200, "JUnit", 10);
        Tester tester2 = new Tester("TEST002", "Mike", 7_500, "Jest", 4);

        Manager manager1 = new Manager("MGR001", "Jack", 15_000, 500);
        Manager manager2 = new Manager("MGR002", "Jill", 13_000, 300);

        Director director = new Director("DIR001", "Wick", 18_000, 0.1, "Agile");

        employeeManager.addEmployee(dev1, dev2, dev3, tester1, tester2, manager1, manager2, director);

        return employeeManager;
    }
}
