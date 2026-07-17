package model;

import interfaces.Workable;

public class Developer extends Employee implements Workable {
    private int experienceYear;
    private String projectName;

    public Developer() {
    }

    public Developer(String id, String name, double salary, int experienceYear, String projectName) {
        super(id, name, salary);
        this.experienceYear = experienceYear;
        this.projectName = projectName;
    }

    @Override
    public void display() {
        super.display();
    }

    @Override
    public double calculateSalary() {
        double bonus = salary * experienceYear * 0.2;
        return salary + bonus;
    }

    @Override
    public void work() {
        System.out.printf("[Developer] %s is working on \"%s\" project\n", name, projectName);
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
