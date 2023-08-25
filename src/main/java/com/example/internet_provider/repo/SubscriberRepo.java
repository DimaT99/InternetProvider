package com.example.internet_provider.repo;

import com.example.internet_provider.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepo extends JpaRepository<Subscriber, Integer> {
    Subscriber findByUsername(String nickname);

}
