package com.endava.amcourse.mvc.controller;

import com.endava.amcourse.mvc.dto.UserDto;
import com.endava.amcourse.mvc.model.Gender;
import com.endava.amcourse.mvc.model.Status;
import com.endava.amcourse.mvc.model.User;
import com.endava.amcourse.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/")
public class HelloController {

    private final UserService userService;

    @RequestMapping(value = {"/", "/login"}, method = GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = POST)
    public String login(@ModelAttribute("user") UserDto user, Model model) {
        boolean isValid = userService.validateUser(user);
        if (isValid) {
            model.addAttribute("username", user.getUsername());
            return "hello";
        } else {
            model.addAttribute("error", "Username or password are incorrect");
            return "login";
        }
    }

    @RequestMapping(value = "/show-users", method = POST)
    public String showUsersByStatusForm(Model model, @RequestParam(name = "status") String status) {
        if (status == null || status.equals("") || !Arrays.stream(Status.values()).map(Enum::toString).collect(Collectors.toList()).contains(status)) {
            model.addAttribute("error", "Enter a valid status");
            return "hello";
        }
        model.addAttribute("status", status);
        model.addAttribute("userList", userService.getUsersByStatus(Status.valueOf(status)));
        return "hello";
    }

    @RequestMapping(value = "/show-users", method = GET)
    public String showUsers(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/show-user/by-id/{id}", method = GET)
    public String showUserById(Model model, @PathVariable(name = "id") int id) {
        model.addAttribute("userById", userService.getUserById(id));
        model.addAttribute("userList", userService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/show-users/by-status", method = GET)
    public String showUsersByStatus(Model model, @RequestParam(name = "status") String status) {
        model.addAttribute("userList", userService.getUsersByStatus(Status.valueOf(status)));
        return "users";
    }

    @RequestMapping(value = "/show-users/{gender}", method = GET)
    public String showUsersByGender(Model model, @PathVariable(name = "gender") String gender) {
        model.addAttribute("userList", userService.getUsersByGender(Gender.valueOf(gender)));
        return "users";
    }

    @RequestMapping(value = "/show-users/by-gender", method = GET)
    public String showUsersByGenderForm(Model model, @RequestParam(name = "gender") String gender) {
        model.addAttribute("userList", userService.getUsersByGender(Gender.valueOf(gender)));
        return "users";
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegisterPage() {
        return "register";
    }

    @RequestMapping(value = "/register", method = POST)
    public String takeRegisterValues(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/show-users";
    }

    @RequestMapping(value = "/json", method = GET)
    @ResponseBody
    public List<User> getJsonUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user/{id}", method = GET)
    @ResponseBody
    public User showUserById(@PathVariable(name = "id") int id) {
        return userService.getUserById(id).get();
    }

    @RequestMapping(value = "/user/delete-by-id/{userId}", method = GET)
    public String removeUser(@PathVariable int userId, Model model){
        userService.deleteUserById(userId);
        model.addAttribute("userList", userService.getAllUsers());
        return "users";
    }
}