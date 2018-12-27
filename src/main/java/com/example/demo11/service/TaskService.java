package com.example.demo11.service;

import com.example.demo11.domain.Task;
import com.example.demo11.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getByUser(Long id) {
        List<Task> tasks = (List<Task>) taskRepo.findAll();
        tasks = tasks.stream()
                .filter(x -> x.getUser().getId().equals(id))
                .collect(Collectors.toList());
        return tasks;
    }

    public void save(Task task) {

        taskRepo.save(task);

    }

    public Iterable<Task> getAll() {
        return taskRepo.findAll();
    }

    public void delete(Long id) {
        taskRepo.deleteById(id);
    }
}
