package com.student.Kata.PP_3_1_2_SpringBoot.controller;

import com.student.Kata.PP_3_1_2_SpringBoot.model.User;
import com.student.Kata.PP_3_1_2_SpringBoot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printUsers(Model model) {

        model.addAttribute("users", userService.listUsers());
        model.addAttribute("user", new User());

        return "users";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String edit(Model model, @RequestParam Long id) {

        model.addAttribute("user", userService.findById(id));

        return "edit";
    }

    @PatchMapping(value = "/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    @DeleteMapping()
    public String delete(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

}
