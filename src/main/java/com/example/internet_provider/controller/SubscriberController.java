package com.example.internet_provider.controller;

import com.example.internet_provider.entity.Subscriber;
import com.example.internet_provider.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class SubscriberController {

    private final SubscriberService subscriberService;

    @Autowired
    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }


    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal Subscriber subscriber) {
        model.addAttribute("username", subscriber.getUsername());
        model.addAttribute("email", subscriber.getEmail());
        return "profile";
    }

}
