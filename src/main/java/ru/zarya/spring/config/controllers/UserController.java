package ru.zarya.spring.config.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ru.zarya.spring.config.dao.UserDaoImpl;
import ru.zarya.spring.config.models.User;

//import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserDaoImpl userDaoImpl;
    @Autowired
    public UserController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDaoImpl.index());
        return "user/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDaoImpl.show(id));
        return "user/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user/new";
    }

    @PostMapping()
    public String create(@ModelAttribute ("user")  User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "user/new";
        }
        userDaoImpl.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDaoImpl.show(id));
        return "/user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, BindingResult bindingResult, @PathVariable("id") int id) {
        if(bindingResult.hasErrors()) {
            return "user/edit";
        }
        userDaoImpl.update(id,user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDaoImpl.delete(id);
        return "redirect:/user";
    }

}

