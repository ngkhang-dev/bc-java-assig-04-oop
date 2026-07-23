package manager;

import model.*;
import util.Util;

import java.util.*;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee... employee) {
        for (Employee e : employee) {
            employees.add(e);
        }
    }

    public void displayEmployees() {
        for (Employee e : employees) {
            e.display();
            System.out.println();
        }
    }

    public void displaySalaries() {
        Map<String, Double> salariesByRole = calculateSalariesByRole();

        double totalSalaries = 0;
        String result = "";

        for (Map.Entry<String, Double> entry : salariesByRole.entrySet()) {
            totalSalaries += entry.getValue();
            result += String.format("- %-13s: %15s\n", entry.getKey(), Util.formatCurrency(entry.getValue()));
        }

        System.out.print(result + String.format("%-15s: %15s\n", "Total salaries", Util.formatCurrency(totalSalaries)));
    }

    public void performActions(int index) {
        if (index < 0 || index >= employees.size()) {
            System.out.println("Invalid index");
            return;
        }

        Employee employee = employees.get(index);
        performActions(employee);
    }

    public <T> void performActions(T object) {
        if (object instanceof Employee e) {
            e.displayDetailInfo();
        }

        if (object instanceof Developer dev) {
            dev.work();
        } else if (object instanceof Tester tester) {
            tester.work();
            tester.report();
        } else if (object instanceof Manager manager) {
            manager.work();
            manager.manage();
        } else if (object instanceof Director director) {
            director.report();
            director.manage();
        } else {
            System.out.println("Invalid object type");
        }
    }

    public void performAllActions() {
        List<Developer> developers = new ArrayList<>();
        List<Tester> testers = new ArrayList<>();
        List<Manager> managers = new ArrayList<>();
        List<Director> directors = new ArrayList<>();

        for (Employee e : employees) {
            if (e instanceof Developer dev) {
                developers.add(dev);
            } else if (e instanceof Tester tester) {
                testers.add(tester);
            } else if (e instanceof Manager manager) {
                managers.add(manager);
            } else if (e instanceof Director director) {
                directors.add(director);
            }
        }

        System.out.println("Performing actions of Developers");
        for (Developer dev : developers) {
            dev.displayDetailInfo();
            dev.work();
        }

        System.out.println("\nPerforming actions of Testers");
        for (Tester tester : testers) {
            tester.displayDetailInfo();
            tester.work();
            tester.report();
        }

        System.out.println("\nPerforming actions of Managers");
        for (Manager manager : managers) {
            manager.displayDetailInfo();
            manager.work();
            manager.manage();
        }

        System.out.println("\nPerforming actions of Directors");
        for (Director director : directors) {
            director.displayDetailInfo();
            director.report();
            director.manage();
        }
    }

    private Map<String, Double> calculateSalariesByRole() {
        Map<String, Double> salariesByRole = new HashMap<String, Double>();

        for (Employee e : employees) {
            String role = e.getRole();

            double newSalary = salariesByRole.getOrDefault(role, 0.0) + e.calculateSalary();
            salariesByRole.put(role, newSalary);
        }

        return salariesByRole;
    }
}
