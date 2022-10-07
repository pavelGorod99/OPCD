package com.vallerry.opcd.service;

import com.vallerry.opcd.data.CompartmentRepository;
import com.vallerry.opcd.data.ContactFormRepository;
import com.vallerry.opcd.data.MissionRepository;
import com.vallerry.opcd.data.WelcomePosterRepository;
import com.vallerry.opcd.model.CompartmentWithIdTitleAndImage;
import com.vallerry.opcd.model.ContactForm;
import com.vallerry.opcd.model.WelcomePoster;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WelcomeService {

    private final ContactFormRepository contactFormRepository;
    private final CompartmentRepository compartmentRepository;
    private final WelcomePosterRepository welcomePosterRepository;

    public WelcomeService(ContactFormRepository contactFormRepository, CompartmentRepository compartmentRepository, WelcomePosterRepository welcomePosterRepository, MissionRepository missionRepository) {
        this.contactFormRepository = contactFormRepository;
        this.compartmentRepository = compartmentRepository;
        this.welcomePosterRepository = welcomePosterRepository;
    }

    @Transactional
    public void insertContactForm(ContactForm contactForm) {
        contactFormRepository.save(contactForm);
    }

    public Iterable<CompartmentWithIdTitleAndImage> findAllCompartmentsForIdTitleAndImage() {
        return compartmentRepository.findAllWithIdTitleAndImage();
    }

    public Iterable<WelcomePoster> findAllPosters() {
        return welcomePosterRepository.findAll();
    }
}
