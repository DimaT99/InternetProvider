package com.example.internet_provider.controller;


import com.example.internet_provider.entity.Role;
import com.example.internet_provider.entity.Subscriber;
import com.example.internet_provider.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Controller
public class RegistrationController {

    private final SubscriberService subscriberService;

    @Autowired
    public RegistrationController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/registration")
    public String registrationPost(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String email) {
        final Subscriber subscriber = new Subscriber();
        subscriber.setPassword(password);
        subscriber.setUsername(username);
        subscriber.setEmail(email);
        subscriber.setRoles(Collections.singleton(Role.USER));
        subscriberService.addUser(subscriber);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            request.getSession().invalidate();
        }
        return "redirect:/";
    }

}
