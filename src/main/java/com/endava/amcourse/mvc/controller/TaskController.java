package com.endava.amcourse.mvc.controller;

import com.endava.amcourse.mvc.model.Task;
import com.endava.amcourse.mvc.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by pcovaliov on 11/27/2018.
 */

@Controller
@RequestMapping(value = "/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @RequestMapping(value = "/show-tasks", method = GET)
    public String showTasks(Model model) {
        model.addAttribute("taskList", taskService.getAllTasks());
        return "tasks";
    }

    @RequestMapping(value = "/add-task", method = GET)
    public String showTaskForm() {
        return "tasks";
    }

    @RequestMapping(value = "/add-task", method = POST)
    public String getTask(@ModelAttribute("task") Task task){
        taskService.add(task);
        return "redirect:/task/show-tasks";
    }
}
