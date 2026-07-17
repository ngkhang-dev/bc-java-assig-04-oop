package model;

import interfaces.Manageable;
import interfaces.Reportable;

public class Manager extends Employee implements Reportable, Manageable {
    private double bonus;

    public Manager() {
    }

    public Manager(String id, String name, double salary, double bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    @Override
    public void display() {
        super.display();
    }

    @Override
    public double calculateSalary() {
        return salary + bonus;
    }

    @Override
    public void manage() {
        System.out.printf("[Manager] %s is managing projects\n", name);
    }

    @Override
    public void report() {
        System.out.printf("[Manager] %s has reported\n", name);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
