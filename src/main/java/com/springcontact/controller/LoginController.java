/*
package com.springcontact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springcontact.service.dto.LoginForm;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping
    public String processLoginForm(LoginForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        // process the login
        // ...
        return "redirect:/contacts/all";
    }
}*/
