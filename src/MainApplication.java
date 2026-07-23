import manager.EmployeeManager;
import model.Developer;
import model.Director;
import model.Manager;
import model.Tester;

public class MainApplication {
    public static void main(String[] args) {
        EmployeeManager employeeManager = initialData();

        System.out.print("""
                =======================================
                Welcome to Employee Application System
                =======================================
                """);

        // Display all employees
        System.out.println("\n1. Display all employees:");
        employeeManager.displayEmployees();

        System.out.println("\n2. Add a new employee:");
        Developer dev = new Developer("DEV004", "Halley", 6_000, 1, "PROJ01 - E-Commerce with Spring Boot");
        Tester test = new Tester("TEST003", "Harry", 5_000, "JUnit", 5);
        Manager mgr = new Manager("MGR003", "Thomas", 10_000, 1000);
        Director dir = new Director("DIR002", "Dillon", 12_000, 0.2, "Agile");
        employeeManager.addEmployee(dev, test, mgr, dir);
        employeeManager.displayEmployees();

        System.out.println("\n3. Display salaries by role:");
        employeeManager.displaySalaries();

        System.out.println("\n4. Perform actions by index = 8:");
        employeeManager.performActions(8);

        System.out.println("\n5. Perform actions by object:");
        employeeManager.performActions(dev);

        System.out.println("\n6. Perform all actions:");
        employeeManager.performAllActions();

        System.out.println("\n7. Exit");
    }

    public static EmployeeManager initialData() {
        EmployeeManager employeeManager = new EmployeeManager();

        employeeManager.addEmployee(
                new Developer("DEV001", "John", 10_000, 3, "PROJ01 - E-Commerce with Spring Boot"),
                new Developer("DEV002", "Tom", 9_000, 2, "PROJ01 - E-Commerce with Spring Boot"),
                new Developer("DEV003", "Hank", 12_000, 4, "PROJ02 - E-Commerce with React.js"),
                new Tester("TEST001", "Jane", 8_200, "JUnit", 10),
                new Tester("TEST002", "Mike", 7_500, "Jest", 4),
                new Manager("MGR001", "Jack", 15_000, 500),
                new Manager("MGR002", "Jill", 13_000, 300),
                new Director("DIR001", "Wick", 18_000, 0.1, "Agile"));

        return employeeManager;
    }
}
