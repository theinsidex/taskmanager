package com.example.demo11.repository;

import com.example.demo11.domain.Task;
import com.example.demo11.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepo extends CrudRepository<Task, Long> {
    List<Task> findAllByUser(User user);
}
