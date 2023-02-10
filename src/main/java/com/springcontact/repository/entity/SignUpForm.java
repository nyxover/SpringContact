package com.springcontact.repository.entity;

import org.springframework.web.multipart.MultipartFile;

public class SignUpForm {  private String firstName;
    private String lastName;
    private String email;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public MultipartFile getPhoto() {
        return photo;
    }


    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    private MultipartFile photo;



    public SignUpForm(String firstName, String lastName, String email, String password, MultipartFile photo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }
}