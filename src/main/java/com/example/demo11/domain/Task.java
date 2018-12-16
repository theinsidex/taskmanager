package com.example.demo11.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    // private User user;
    private LocalDate dateOfCreate;
    private LocalDate dateOfEnd;

    public Task() {
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public LocalDate getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(LocalDate dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public LocalDate getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(LocalDate dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
