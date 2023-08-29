package com.example.internet_provider.controller;

import com.example.internet_provider.entity.Role;
import com.example.internet_provider.entity.Subscriber;
import com.example.internet_provider.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private SubscriberService subscriberService;

    @Autowired
    public AdminController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping("/subscribers")
    public String getSubscribers(Model model) {
        final List<Subscriber> subscribers = subscriberService.getSubscriber();
        model.addAttribute("subscribers", subscribers);
        return "all-subscribers";
    }

    @GetMapping("/add-user-from-admin")
    public String addUserFromAdmin(@AuthenticationPrincipal Subscriber subscriber) {
        System.out.println(subscriber);
        return "userFromAdmin";
    }

    @PostMapping("/registration-from-admin")
    public String registrationPost(@RequestParam String username,
                                   @RequestParam String firstname,
                                   @RequestParam String lastname,
                                   @RequestParam String password,
                                   @RequestParam String email) {
        final Subscriber subscriber = new Subscriber();
        subscriber.setUsername(username);
        subscriber.setFirstname(firstname);
        subscriber.setLastname(lastname);
        subscriber.setPassword(password);
        subscriber.setEmail(email);
        subscriber.setRoles(Collections.singleton(Role.USER));
        subscriberService.addUser(subscriber, false);
        return "redirect:/subscribers";
    }

    @GetMapping("/subscribers/delete/{id}")
    public String deleteSubscriber(Model model, @PathVariable Integer id) {
        final Optional<Subscriber> subscriberById = subscriberService.getSubscriberById(id);
        final Subscriber subscriber = subscriberById.orElse(null);
        subscriberService.deleteSubscriber(subscriber);
        return "redirect:/";
    }
}
