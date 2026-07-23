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

    @Override
    public void displayDetailInfo() {
        super.display();
        System.out.printf(" Stock: %5.1f%%| Strategy: %20s|\n", stockPercent * 100, strategy);
    }

    @Override
    public double calculateSalary() {
        return salary + stockPercent * salary;
    }

    @Override
    public void manage() {
        System.out.printf("[Director] %s is managing with a  %s strategy\n", name, strategy);
    }

    @Override
    public void report() {
        System.out.printf("[Director] %s has %.1f%% stock\n", name, stockPercent * 100);
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
