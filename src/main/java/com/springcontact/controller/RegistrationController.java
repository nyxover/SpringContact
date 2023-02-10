/*
package com.springcontact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springcontact.service.dto.RegistrationForm;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "register";
    }

    @PostMapping
    public String processRegistrationForm(RegistrationForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        // process the registration
        // ...
        return "redirect:/contacts/all";
    }
}*/
