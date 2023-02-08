package com.springcontact.controller;

<<<<<<< HEAD
import com.springcontact.repository.entity.Contact;
import com.springcontact.service.ContactService;
=======
import com.springcontact.springcontact.repository.entity.Contact;
import com.springcontact.springcontact.service.ContactService;
>>>>>>> ae8f483a56b582a24d9fa2f18c46f9b92d95f2f4
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class ContactController {


    @Autowired
    private ContactService contactService;


    @GetMapping("/all")
    public String displayAllContacts(Model model) {
        List<ContactDto> contactList = contactService.fetchContacts();
        model.addAttribute("contacts", contactList);
        return "home.html";
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

    @PostMapping("/add")
    public String addContactFormSubmission(Contact contact, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "add-contact";
        }
        contactService.addContact(contact);
        return "redirect:/contact/all";
    }

}
