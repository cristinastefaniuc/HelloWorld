package com.endava.amcourse.mvc.service;

import com.endava.amcourse.mvc.model.Task;

import java.util.List;

/**
 * Created by pcovaliov on 11/27/2018.
 */
public interface TaskService {

    List<Task> getAllTasks();

    void add(Task task);
}
