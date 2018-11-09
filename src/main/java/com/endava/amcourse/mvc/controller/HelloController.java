package com.endava.amcourse.mvc.controller;

import com.endava.amcourse.mvc.model.Status;
import com.endava.amcourse.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.endava.amcourse.mvc.dao.DatabaseImitation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping(value = "/")
public class HelloController {

    @RequestMapping(value = {"/", "/login"}, method = GET)
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = POST)
    public String login(@ModelAttribute("user") User user, Model model) {
        if (checkUser(user)) {
            model.addAttribute("username", user.getUsername());
            return "hello";
        } else {
            model.addAttribute("error", "Username or password are incorrect");
            return "login";
        }
    }

    @RequestMapping(value = "/show-users", method = POST)
    public String showUsersByStatusForm(Model model, @RequestParam(name = "status") String status) {
        model.addAttribute("status", status);
        model.addAttribute("userList", getUsersByStatus(Status.valueOf(status)));
        return "hello";
    }

    @RequestMapping(value = "/show-users", method = GET)
    public String showUsers(Model model) {
        model.addAttribute("userList", users);
        return "users";
    }

    @RequestMapping(value = "/show-user/by-id/{id}", method = GET)
    public String showUserById(Model model, @PathVariable(name = "id") int id) {
        model.addAttribute("userById", getUserById(id));
        model.addAttribute("userList", users);
        return "users";
    }

    @RequestMapping(value = "/show-users/by-status", method = GET)
    public String showUsersByStatus(Model model, @RequestParam(name = "status") String status) {
        model.addAttribute("userList", getUsersByStatus(Status.valueOf(status)));
        return "users";
    }

    @RequestMapping(value = "/json", method = GET)
    @ResponseBody
    public List<User> getJsonUsers() {
        return users;
    }
}