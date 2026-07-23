package model;

import interfaces.Reportable;
import interfaces.Workable;

public class Tester extends Employee implements Workable, Reportable {
    private String testingTool;
    private int bugCount;

    public Tester() {

    }

    public Tester(String id, String name, double salary, String testingTool, int bugCount) {
        super(id, name, salary, "Tester");
        this.testingTool = testingTool;
        this.bugCount = bugCount;
    }

    @Override
    public void displayDetailInfo() {
        super.display();
        System.out.printf(" Testing Tool: %20s| Bug Count: %2d|\n", testingTool, bugCount);
    }

    @Override
    public double calculateSalary() {
        double bonus = salary * bugCount * 0.05;
        return salary + bonus;
    }

    @Override
    public void work() {
        System.out.printf("[Tester] %s is testing with %s\n", name, testingTool);
    }

    @Override
    public void report() {
        System.out.printf("[Tester] %s has %d bugs\n", name, bugCount);
    }

    public String getTestingTool() {
        return testingTool;
    }

    public void setTestingTool(String testingTool) {
        this.testingTool = testingTool;
    }

    public int getBugCount() {
        return bugCount;
    }

    public void setBugCount(int bugCount) {
        this.bugCount = bugCount;
    }
}
