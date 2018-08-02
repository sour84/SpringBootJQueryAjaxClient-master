package com.javasampleapproach.jqueryajax.impl;

import com.javasampleapproach.jqueryajax.model.ContactEntity;

import com.javasampleapproach.jqueryajax.repository.ContactRepository;
import com.javasampleapproach.jqueryajax.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;


    @Override
    public List<ContactEntity> findByLastName(String lastName) {
        return contactRepository.findByLastName(lastName);
    }
@Override
    public List<ContactEntity> findAll() {
        return contactRepository.findAll(sortByIdAsc());
    }


    public ContactEntity save(ContactEntity contact) {
        return contactRepository.saveAndFlush(contact);
    }

    @Override
    public ContactEntity delete(Integer id) {
        ContactEntity contactEntity = contactRepository.findById(id).get();
        contactRepository.delete(contactEntity);
        return contactEntity;
    }

    @Override
    public ContactEntity findById(int id) {

        return contactRepository.findById(id).get();
    }



    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "firstName");
    }
}

