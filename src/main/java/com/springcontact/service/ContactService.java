package com.springcontact.service;


import com.springcontact.repository.entity.Contact;
import com.springcontact.repository.ContactRepository;
import com.springcontact.service.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public void addContact(Contact contact){
        ContactRepository.save(contact);
    }

    public List<ContactDto> fetchcontacts(){
        return contactRepository
                .findAll()
                .stream()
                .map(contact -> ContactDto.fromEntity(Contact))
                .collect(Collectors.toList());
    }

    public Optional<ContactDto> fetchById(Long id){
        return contactRepository
                .findById(id)
                .map(contact -> ContactDto.fromEntity((Contact));
    }

}

