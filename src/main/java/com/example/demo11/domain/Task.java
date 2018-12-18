package com.example.demo11.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private User user;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateOfCreate;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateOfEnd;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        dateOfCreate = new Date();
    }
}
