package model;

import interfaces.Manageable;
import interfaces.Reportable;
import interfaces.Workable;
import util.Util;

public class Manager extends Employee implements Workable, Reportable, Manageable {
    private double bonus;

    public Manager() {
    }

    public Manager(String id, String name, double salary, double bonus) {
        super(id, name, salary, "Manager");
        this.bonus = bonus;
    }

    @Override
    public void displayDetailInfo() {
        super.display();
        System.out.printf(" Bonus: %12s|\n", Util.formatCurrency(bonus));
    }

    @Override
    public double calculateSalary() {
        return salary + bonus;
    }

    @Override
    public void work() {
        System.out.printf("[Manager] %s is working on projects\n", name);
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
