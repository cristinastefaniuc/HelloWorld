package com.endava.amcourse.mvc.dao.impl;

import com.endava.amcourse.mvc.dao.TaskDao;
import com.endava.amcourse.mvc.model.Task;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pcovaliov on 11/27/2018.
 */
@RequiredArgsConstructor
@Repository
public class TaskDaoImpl implements TaskDao {

    private final SessionFactory sessionFactory;

    @Override
    public List<Task> getAllTasks() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT t FROM Task t", Task.class)
                .getResultList();
    }

    @Override
    public void persist(Task task) {
        sessionFactory.getCurrentSession()
                .persist(task);
    }
}
