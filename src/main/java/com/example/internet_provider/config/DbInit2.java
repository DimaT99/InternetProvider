package com.example.internet_provider.config;

import com.example.internet_provider.entity.Subscriber;
import com.example.internet_provider.service.SubscriberService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class DbInit2 {
    private final SubscriberService subscriberService;

    private Random random = new Random();

    public DbInit2(final SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @PostConstruct
    private void postConstruct() {
        final Subscriber user = new Subscriber();
        user.setEmail("user@gmail.com");
        user.setUsername("cat");
        user.setPassword("cat");

        subscriberService.addUser(user, false);

        final Subscriber admin = new Subscriber();
        admin.setEmail("admin@gmail.com");
        admin.setUsername("admin");
        admin.setPassword("admin");

        subscriberService.addUser(admin, true);
    }
}