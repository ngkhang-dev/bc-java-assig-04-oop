package model;

import util.Util;

public abstract class Employee {
    protected String id;
    protected String name;
    protected double salary;
    protected String role;

    public Employee() {
    }

    public Employee(String id, String name, double salary, String role) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    public void display() {
        System.out.printf("|ID: %-10s| Name: %-15s| Role: %10s| Salary: %15s| Total Salary: %15s|", id, name, role, Util.formatCurrency(salary), Util.formatCurrency(calculateSalary()));
    }

    public abstract void displayDetailInfo();

    public abstract double calculateSalary();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
