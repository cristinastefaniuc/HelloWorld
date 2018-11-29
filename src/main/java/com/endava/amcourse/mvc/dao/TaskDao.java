package com.endava.amcourse.mvc.dao;

import com.endava.amcourse.mvc.model.Task;

import java.util.List;

/**
 * Created by pcovaliov on 11/27/2018.
 */
public interface TaskDao {

    List<Task> getAllTasks();

    void persist(Task task);

}
