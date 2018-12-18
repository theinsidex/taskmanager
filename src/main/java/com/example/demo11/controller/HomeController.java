package com.example.demo11.controller;

import com.example.demo11.domain.Task;
import com.example.demo11.domain.User;
import com.example.demo11.service.TaskService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {
    private final TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam String name, @RequestParam String description, Map<String, Object> model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Iterable<Task> tasks = taskService.getByUser(user);
        return "main";
    }

    @GetMapping("/")
    public String toMain() {
        Iterable<Task> tasks = taskService.getAll();
        return "main";
    }


    @GetMapping("/main")
    public String main() {
        Iterable<Task> tasks = taskService.getAll();
        return "main";
    }
}
