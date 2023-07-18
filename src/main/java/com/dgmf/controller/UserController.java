package com.dgmf.controller;

import com.dgmf.entity.user.User;
import com.dgmf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getUser(Model model) {
        model.addAttribute("user", userService.getAllUsers());

        return "users";
    }
}
