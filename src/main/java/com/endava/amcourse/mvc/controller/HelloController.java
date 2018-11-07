package com.endava.amcourse.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.endava.amcourse.mvc.dao.DatabaseImitation.*;

@Controller
@RequestMapping(value = "/")
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(Model model) {
        model.addAttribute("message", 2345);
        return "hello";
    }

    @RequestMapping(value = "/model-and-view", method = RequestMethod.GET)
    public ModelAndView printWelcome() {
        return new ModelAndView("hello", "message", "Hello model and view!");
    }

    @RequestMapping(value = "/show-users", method = RequestMethod.GET)
    public String showUsers(Model model) {
        model.addAttribute("userList", users);
        return "users";
    }

    @RequestMapping(value = "/show-user/by-id/{id}", method = RequestMethod.GET)
    public String showUserById(Model model, @PathVariable(name = "id") int id) {
        model.addAttribute("userById", getUserById(id));
        model.addAttribute("userList", users);
        return "users";
    }
}