package com.springcontact.controller;

import com.springcontact.repository.entity.User;
import com.springcontact.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (userService.isUserPresent(user.getEmail())) {
            model.addAttribute("emailError", "Email already exists");
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        if (!userService.isUserPresent(user.getEmail())) {
            model.addAttribute("emailError", "Email not found");
            return "login";
        }
        User userFromDb = userService.findByEmail(user.getEmail());
        if (!userFromDb.getPassword().equals(user.getPassword())) {
            model.addAttribute("passwordError", "Wrong password");
            return "login";
        }
        return "redirect:/contacts/all";
    }
}