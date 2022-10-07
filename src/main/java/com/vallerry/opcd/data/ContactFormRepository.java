package com.vallerry.opcd.data;

import com.vallerry.opcd.model.ContactForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormRepository extends CrudRepository<ContactForm, Long> {}
