package com.example.demo11.Controllers;

import com.example.demo11.Repos.TaskRepo;
import com.example.demo11.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class TaskController {
    @Autowired
    private TaskRepo taskRepo;

    public TaskController() {
    }
    public TaskController(TaskRepo taskRepo) {
        this.taskRepo=taskRepo;
    }

    @GetMapping("/add")
public void addTask(Task task, Map<String,Object> model)
    {
        
    }
}
