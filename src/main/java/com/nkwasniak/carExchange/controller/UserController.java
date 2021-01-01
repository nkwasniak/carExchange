package com.nkwasniak.carExchange.controller;

import com.nkwasniak.carExchange.dto.mapper.DataMapper;
import com.nkwasniak.carExchange.dto.UserDTO;
import com.nkwasniak.carExchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.nkwasniak.carExchange.service.implementation.UserDetailsServiceImpl.activeUserId;

@Controller
@RequestMapping(path = "/")

public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DataMapper dataMapper;

    @GetMapping(path = "edit-profile")
    public ModelAndView editUserForm() {
        ModelAndView modelAndView = new ModelAndView("edituser");
        UserDTO userDTO = dataMapper.convertToDto(userService.findByUserId(activeUserId));
        modelAndView.addObject("user", userDTO);
        return modelAndView;
    }

    @PostMapping(path = "edit-profile")
    public String updateUser(@ModelAttribute UserDTO userDTO, Model model) {
        userService.saveUser(dataMapper.convertToEntity(userDTO));
        model.addAttribute("user", userDTO);
        return "userprofile";
    }

    @PostMapping(path = "/delete-account")
    public String deleteUser() {
        userService.deleteByUserId(activeUserId);
        activeUserId = null;
        return "redirect:logout";
    }
}

