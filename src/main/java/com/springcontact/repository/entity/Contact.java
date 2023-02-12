package com.springcontact.repository.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String first_name;
    private String last_name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "contact")
    private List<ContactRelation> relations;

    public Contact() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public List<ContactRelation> getRelations() { return relations; }
    public void setRelations(List<ContactRelation> relations) { this.relations = relations; }
}

@Entity
class ContactRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Contact contact;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Contact getContact() { return contact; }
    public void setContact(Contact contact) { this.contact = contact; }
}
