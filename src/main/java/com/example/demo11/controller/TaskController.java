package com.example.demo11.controller;

import com.example.demo11.domain.Status;
import com.example.demo11.domain.Task;
import com.example.demo11.domain.User;
import com.example.demo11.service.TaskService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TaskController {
    private final TaskService taskService;
    private LocalDate nowDate;
    private Status status;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
        nowDate = LocalDate.now();
        status = Status.Processing;
    }

    @RequestMapping(value = "/editor")
    public String editorPage(Model model) {
        model.addAttribute("task", new Task());
        return "editor";
    }

    @RequestMapping(value = "/editor/submit", method = RequestMethod.POST)
    public String submitTask(
            @AuthenticationPrincipal User user,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam LocalDate dateOfEnd, Model model) {
        Task task = new Task(name, description, user, dateOfEnd);
        taskService.save(task);
        return "redirect:/main";
    }


    @PostMapping("/main/delete")

    public String deleteTask(@RequestParam Long id) {
        taskService.delete(id);
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(Model model, @AuthenticationPrincipal User user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Iterable<Task> tasks = taskService.getByUser(user.getId());
        model.addAttribute("tasks", tasks);
        return "main";
    }

    @GetMapping("/listLost")
    public String lost(Model model, @AuthenticationPrincipal User user) {
        List<Task> list = (List<Task>) taskService.getByUser(user.getId());
        List<Task> lostList = new ArrayList<>();
        List<Task> task = list.stream()
                .filter(x -> nowDate.isAfter(x.getDateOfEnd()))
                .collect(Collectors.toList());
        Iterable<Task> tasks = task;
        model.addAttribute("tasks", tasks);
        return "lostList";
    }


}
