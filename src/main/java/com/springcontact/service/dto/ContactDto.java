package com.springcontact.service.dto;

import com.springcontact.repository.entity.Contact;

public record ContactDto(Long id, String First_name, String Last_name, String Email, String phone) {

    public static ContactDto fromEntity(Contact contact) {

        ContactDto dto = new ContactDto(
                contact.getId(),
                contact.getFirst_name(),
                contact.getLast_name(),
                contact.getEmail(),
                contact.getPhone());
        return dto;
    }

}