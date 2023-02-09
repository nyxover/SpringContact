package com.springcontact.service;


import com.springcontact.repository.entity.Contact;
import com.springcontact.repository.ContactRepository;
import com.springcontact.service.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public void addContact(Contact contact){
        contactRepository.save(contact);
    }



    public List<ContactDto> fetchContacts(){
        return contactRepository
                .findAll()
                .stream()
                .map(contact -> ContactDto.fromEntity(contact))
                .collect(Collectors.toList());
    }

    public Optional<ContactDto> fetchById(Long id){
        return contactRepository
                .findById(id)
                .map(contact -> ContactDto.fromEntity(contact));
    }

    public void updateContact(Long id, Contact contact) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            Contact existingContact = optionalContact.get();
            existingContact.setFirst_name(contact.getFirst_name());
            existingContact.setLast_name(contact.getLast_name());
            existingContact.setEmail(contact.getEmail());
            existingContact.setPhone(contact.getPhone());
            contactRepository.save(existingContact);
        } else {
            throw new ContactNotFoundException("Contact not found with id " + id);
        }
    }

    public class ContactNotFoundException extends NoSuchElementException {

        public ContactNotFoundException(String message) {
            super(message);
        }
    }

}

