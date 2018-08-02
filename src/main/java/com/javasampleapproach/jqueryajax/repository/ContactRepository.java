package com.javasampleapproach.jqueryajax.repository;


import com.javasampleapproach.jqueryajax.model.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

    List<ContactEntity> findByLastName(String lastName);

}
