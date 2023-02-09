package com.springcontact.controller;

import com.springcontact.repository.entity.Contact;
import com.springcontact.service.ContactService;
import com.springcontact.service.dto.ContactDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/contacts")
public class ContactController {


    @Autowired
    private ContactService contactService;


    @GetMapping("/all")
    public String displayAllContacts(Model model) {
        List<ContactDto> contactList = contactService.fetchContacts();
        model.addAttribute("contacts", contactList);
        return "home";
    }

    @GetMapping("/{id}")
    public  String displaySpecificContact(@PathVariable Long id, Model model){
        Optional<ContactDto> contactOptional = contactService.fetchById(id);
        if (contactOptional.isPresent()){
            model.addAttribute("contact", contactOptional.get());
            return "contact-details.html";
        } else {
            return "404.html";
        }
    }

    @GetMapping ("/add")
    public String displayAddContactForm(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "add-contact";
    }

    @GetMapping("/edit/{id}")
    public String editContactForm(@PathVariable Long id, Model model) {
        Optional<ContactDto> contactOptional = contactService.fetchById(id);
        if (contactOptional.isPresent()) {
            model.addAttribute("contact", contactOptional.get());
            return "edit-contact.html";
        } else {
            return "404.html";
        }
    }

    @PostMapping("/edit/{id}")
    public String editContactFormSubmission(@PathVariable Long id, Contact contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-contact";
        }
        contactService.updateContact(id, contact);
        return "redirect:/contacts/all";
    }

    @PostMapping("/add")
    public String addContactFormSubmission(Contact contact, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "add-contact";
        }
        contactService.addContact(contact);
        return "redirect:/contacts/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts/all";
    }

}
