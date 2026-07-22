package model;

import interfaces.Manageable;
import interfaces.Reportable;

public class Director extends Employee implements Reportable, Manageable {
    private double stockPercent;
    private String strategy;

    public Director() {
    }

    public Director(String id, String name, double salary, double stockPercent, String strategy) {
        super(id, name, salary, "Director");
        this.stockPercent = stockPercent;
        this.strategy = strategy;
    }

    public void displayDirectorInfo() {
        super.display();
        System.out.printf(" Stock: %6s| Strategy: %20s|\n", String.format("%,.0f", stockPercent), strategy);
    }

    @Override
    public void display() {
        super.display();
    }

    @Override
    public double calculateSalary() {
        return salary + stockPercent * salary;
    }

    @Override
    public void manage() {
        System.out.printf("[Director] %s is managing %s\n", name, strategy);
    }

    @Override
    public void report() {
        System.out.printf("[Director] %s has %d%% stock\n", name, stockPercent);
    }

    public double getStockPercent() {
        return stockPercent;
    }

    public void setStockPercent(double stockPercent) {
        this.stockPercent = stockPercent;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
}
