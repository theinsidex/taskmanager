package com.example.demo11.service;

import com.example.demo11.domain.Task;
import com.example.demo11.domain.User;
import com.example.demo11.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getByUser(User user) {
        return taskRepo.findAllByUser(user);
    }

    public void save(Task task) {
        taskRepo.save(task);
    }

    public Iterable<Task> getAll() {
        return taskRepo.findAll();
    }
}
