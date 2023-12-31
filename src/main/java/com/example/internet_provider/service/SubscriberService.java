package com.example.internet_provider.service;

import com.example.internet_provider.entity.Role;
import com.example.internet_provider.entity.Subscriber;
import com.example.internet_provider.repo.SubscriberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriberService implements UserDetailsService {

    private final SubscriberRepo subscriberRepo;


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SubscriberService(SubscriberRepo subscriberRepo, PasswordEncoder passwordEncoder) {
        this.subscriberRepo = subscriberRepo;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Subscriber subscriber = subscriberRepo.findByUsername(username);

        if (subscriber == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return (UserDetails) subscriber;
    }
    public List<Subscriber> getSubscriber() {
        return subscriberRepo.findAll();
    }
    public boolean addUser(final Subscriber subscriber, final boolean isAdmin) {
        Subscriber userFromDb = subscriberRepo.findByUsername(subscriber.getUsername());

        if (userFromDb != null) {
            return false;
        }

        if (isAdmin) {
            subscriber.setRoles(Collections.singleton(Role.ADMIN));
        } else {
            subscriber.setRoles(Collections.singleton(Role.USER));
        }

        subscriber.setPassword(passwordEncoder.encode(subscriber.getPassword()));

        subscriberRepo.save(subscriber);

        return true;
    }
    public Optional<Subscriber> getSubscriberById(final Integer id) {
        return subscriberRepo.findById(id);
    }

    public void deleteSubscriber(final Subscriber subscriber) {
        subscriberRepo.delete(subscriber);
    }
}
