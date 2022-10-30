package com.example.Lab3_06.models;

import javax.persistence.Entity;

@Entity
public class InternalTask extends Task{


    public InternalTask() {
    }

    public InternalTask(String title, String dueDate, boolean status) {
        super(title, dueDate, status);
    }
}
