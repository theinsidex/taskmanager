package com.example.demo11.Controllers;

import com.example.demo11.Repos.TaskRepo;
import com.example.demo11.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private TaskRepo taskRepository;

    public HomeController(TaskRepo taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/login")
    public String mains(Map<String,Object> model)
    {
        Iterable<Task> tasks=taskRepository.findAll();
        model.put("tasks",tasks);
        return "login";
    }

    @PostMapping
    public String add(@RequestParam String name,@RequestParam String description,Map<String,Object> model)
    {
        Task task=new Task(name,description);
        taskRepository.save(task);

        Iterable<Task> tasks=taskRepository.findAll();
        model.put("tasks",tasks);
        return "greeting";
    }
    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Task> messages = taskRepository.findAll();

        model.put("messages", messages);

        return "main";
    }
}
