package com.vallerry.opcd.web.controller;

import com.vallerry.opcd.model.*;
import com.vallerry.opcd.service.AboutUsService;
import com.vallerry.opcd.service.EventService;
import com.vallerry.opcd.service.NewsService;
import com.vallerry.opcd.service.WelcomeService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class GuestController {

    private final WelcomeService welcomeService;
    private final AboutUsService aboutUsService;
    private final EventService eventService;
    private final NewsService newsService;

    public GuestController(WelcomeService welcomeService, AboutUsService aboutUsService, EventService eventService, NewsService newsService) {
        this.welcomeService = welcomeService;
        this.aboutUsService = aboutUsService;
        this.eventService = eventService;
        this.newsService = newsService;
    }

    @PostMapping(value = "/register_user_contact")
    public void registerUserContact(@RequestBody ContactForm contactForm) {
        welcomeService.insertContactForm(contactForm);
    }

    @ResponseBody
    @GetMapping("/compartments_id_title_image")
    public Iterable<CompartmentWithIdTitleAndImage> getCompartments() {
        return welcomeService.findAllCompartmentsForIdTitleAndImage();
    }

    @ResponseBody
    @GetMapping("/posters")
    public Iterable<WelcomePoster> getPosters() {
        return welcomeService.findAllPosters();
    }

    @ResponseBody
    @GetMapping("/mission_post")
    public Iterable<MissionPost> getMissionPost() {
        return aboutUsService.findAllMissionPosts();
    }

    @ResponseBody
    @GetMapping("/compartments")
    public Iterable<Compartment> getAllCompartments() {
        return aboutUsService.findAllCompartments();
    }

    @ResponseBody
    @GetMapping("/compartment_posts_by_compartment_id")
    public Iterable<CompartmentPost> getAllCompartmentPostsByCompartmentId(@RequestParam Long id) {
        return aboutUsService.findAllCompartmentPostsByCompartmentId(id);
    }

    @ResponseBody
    @GetMapping("/partners")
    public Iterable<Partner> getAllPartners() {
        return aboutUsService.findAllPartners();
    }

    @ResponseBody
    @GetMapping("/events")
    public Iterable<Event> getAllEvents() {
        return eventService.findAll();
    }

    @ResponseBody
    @GetMapping("/news")
    public Iterable<News> getAllNews() {
        return newsService.findAll();
    }
}
