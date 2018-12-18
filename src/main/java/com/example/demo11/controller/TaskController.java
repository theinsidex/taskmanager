package com.example.demo11.controller;

import com.example.demo11.domain.Task;
import com.example.demo11.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    public String addTask(Task task) {
        taskService.save(task);
        return "main";
    }

    @PostMapping("/delete")

    public String deleteTask(Task task) {
        Long id = task.getId();
        taskService.delete(id);
        return "main";

    }

}
