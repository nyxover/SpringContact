package com.springcontact.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class LoginForm {

    @NotBlank(message = "Email est obligatoire")
    @Email(message = "Adresse email invalide")
    private String email;

    @NotBlank(message = "Mot de passe est obligatoire")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}