package com.example.demo11.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "thetask")
@NoArgsConstructor
@Getter
@Setter

public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDate dateOfCreate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfEnd;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "STATUS", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "status_id"))
    private Status status;


    public Task(String name, String description, User user, LocalDate dateOfEnd) {
        super();
        this.name = name;
        this.description = description;
        this.user = user;
        this.status = Status.Processing;
        this.dateOfCreate = LocalDate.now();
        this.dateOfEnd = dateOfEnd;
    }
}