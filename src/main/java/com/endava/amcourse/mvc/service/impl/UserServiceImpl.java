package com.endava.amcourse.mvc.service.impl;

import com.endava.amcourse.mvc.dao.UserDao;
import com.endava.amcourse.mvc.dto.UserDto;
import com.endava.amcourse.mvc.model.Status;
import com.endava.amcourse.mvc.model.User;
import com.endava.amcourse.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public Optional<User> getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUsersByStatus(Status status) {
        return userDao.getUsersByStatus(status);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public boolean validateUser(UserDto userDto) {
        return userDao.getAllUsers().stream()
                .anyMatch(u -> userDto.getUsername().equals(u.getUsername()) && userDto.getPassword().equals(u.getPassword()));
    }
}
