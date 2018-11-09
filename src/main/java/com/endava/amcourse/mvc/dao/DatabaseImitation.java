package com.endava.amcourse.mvc.dao;

import com.endava.amcourse.mvc.model.Status;
import com.endava.amcourse.mvc.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.endava.amcourse.mvc.model.Status.*;

public class DatabaseImitation {

    public static List<User> users = Arrays.asList(
            new User(1, "Ann", "111111", 22, ACTIVE),
            new User(2, "Petru", "111111", 33, INACTIVE),
            new User(3, "Kate", "111111", 25, BANNED),
            new User(4, "Vasea", "111111", 35, ACTIVE),
            new User(5, "Alex", "111111", 21, ACTIVE),
            new User(6, "Victor", "111111", 24, INACTIVE),
            new User(7, "Olga", "111111", 23, SUSPENDED)
    );

    public static User getUserById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public static List<User> getUsersByStatus(Status status) {
        return users.stream()
                .filter(user -> user.getStatus() == status)
                .collect(Collectors.toList());
    }

    // there are several ways to implement this: equals in user, foreach and compare two fields, stream
    public static boolean checkUser(User user) {
        return users.stream()
                .anyMatch(u -> user.getUsername().equals(u.getUsername())
                        && user.getPassword().equals(u.getPassword()));
    }
}
