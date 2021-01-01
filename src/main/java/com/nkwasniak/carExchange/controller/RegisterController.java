package com.nkwasniak.carExchange.controller;

import com.nkwasniak.carExchange.database.entity.User;
import com.nkwasniak.carExchange.service.implementation.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class RegisterController {
    @Autowired
    private UserDetailsServiceImpl userService;

    @GetMapping("adduser")
    public ModelAndView registerForm() {
        ModelAndView model = new ModelAndView("signup");
        return model;
    }

    @PostMapping("adduser")
    public String registerUser(@Valid @ModelAttribute("User") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:error";
        }
        userService.createUser(user);
        return "redirect:main";
    }
}
