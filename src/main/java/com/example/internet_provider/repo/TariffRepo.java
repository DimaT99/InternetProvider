package com.example.internet_provider.repo;

import com.example.internet_provider.entity.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepo extends JpaRepository<Tariff, Integer> {
}
