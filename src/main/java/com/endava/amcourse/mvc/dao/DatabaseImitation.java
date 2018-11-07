package com.endava.amcourse.mvc.dao;

import com.endava.amcourse.mvc.model.User;

import java.util.Arrays;
import java.util.List;

public class DatabaseImitation {

    public static List<User> users = Arrays.asList(
            new User(1, "Ann", 22),
            new User(2, "Petru", 33),
            new User(3, "Kate", 55),
            new User(4, "Vasea", 35)
    );

    public static User getUserById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
}
