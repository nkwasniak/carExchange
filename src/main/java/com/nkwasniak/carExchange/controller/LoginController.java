package com.nkwasniak.carExchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.nkwasniak.carExchange.service.implementation.UserDetailsServiceImpl.activeUserId;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping(path = {"", "main"})
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView("main");
        modelAndView.addObject("activeUser", activeUserId);
        return modelAndView;
    }

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("login")
    public String afterLogin() {
        return "main";
    }

    @GetMapping("logout")
    public ModelAndView logoutPage() {
        ModelAndView modelAndView = new ModelAndView("logout");
        modelAndView.addObject("activeUser", activeUserId);
        return modelAndView;
    }

    @PostMapping("logout")
    public ModelAndView afterLogout() {
        ModelAndView modelAndView = new ModelAndView("login");
        activeUserId = null;
        return modelAndView;
    }

}
