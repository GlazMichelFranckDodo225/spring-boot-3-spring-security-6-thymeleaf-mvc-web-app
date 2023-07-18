package com.dgmf.controller;

import com.dgmf.dto.UserDTO;
import com.dgmf.entity.user.User;
import com.dgmf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping("/registration-form")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());

        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserDTO userDTO) {
        User user = userService.registerUser(userDTO);
        // Publish the verification email event here

        return "redirect:/registration/registration-form?success";
    }
}
