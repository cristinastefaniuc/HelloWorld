package com.endava.amcourse.mvc.dao;

import com.endava.amcourse.mvc.model.Status;
import com.endava.amcourse.mvc.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> getAllUsers();

    Optional<User> getUserById(int id);

    List<User> getUsersByStatus(Status status);

}
