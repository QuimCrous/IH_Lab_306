package com.example.Lab3_06.models;

import javax.persistence.Entity;

@Entity
public class BillableTask extends Task{
    private double hourlyRate;

    public BillableTask() {
    }


    public BillableTask(String title, String dueDate, boolean status, double hourlyRate) {
        super(title, dueDate, status);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
