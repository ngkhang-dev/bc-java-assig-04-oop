package manager;

import model.*;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Double> salaries = calculatorSalaries();

        double totalSalaries = 0;
        String result = "";
        for (int i = 0; i < salaries.size(); i++) {
            String type;
            double salary = salaries.get(i);
            totalSalaries += salary;

            switch (i) {
                case 0:
                    type = "Developer";
                    break;
                case 1:
                    type = "Tester";
                    break;
                case 2:
                    type = "Director";
                    break;
                default:
                    type = "Manager";
            }
            result += String.format("- %-13s: %15s\n", type, Util.formatCurrency(salary));
        }

        System.out.println(result + String.format("%-15s: %15s\n", "Total salaries",
                Util.formatCurrency(totalSalaries)));

    }

    public void performActions(Employee employee) {
        if (employee instanceof Developer dev) {
            dev.displayDeveloperInfo();
            dev.work();
            return;
        }

        if (employee instanceof Tester tester) {
            tester.displayTesterInfo();
            tester.work();
            tester.report();
            return;
        }
        if (employee instanceof Manager manager) {
            manager.displayManagerInfo();
            manager.report();
            manager.manage();
            return;
        }

        if (employee instanceof Director director) {
            director.displayDirectorInfo();
            director.report();
            return;
        }
    }

    private List<Double> calculatorSalaries() {
        int iDev = 0;
        int iTest = 1;
        int iDir = 2;
        int iMan = 3;

        List<Double> salaries = Arrays.asList(0.0, 0.0, 0.0, 0.0);

        for (Employee e : employees) {
            String className = e.getClass().getSimpleName();

            switch (className) {
                case "Developer":
                    salaries.set(iDev, salaries.get(iDev) + e.getSalary());
                    break;
                case "Tester":
                    salaries.set(iTest, salaries.get(iTest) + e.getSalary());
                    break;
                case "Director":
                    salaries.set(iDir, salaries.get(iDir) + e.getSalary());
                    break;
                default:
                    salaries.set(iMan, salaries.get(iMan) + e.getSalary());
                    break;
            }
        }

        return salaries;
    }
}
