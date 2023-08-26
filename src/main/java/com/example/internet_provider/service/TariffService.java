package com.example.internet_provider.service;

import com.example.internet_provider.entity.Subscriber;
import com.example.internet_provider.entity.Tariff;
import com.example.internet_provider.repo.TariffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TariffService {
    private TariffRepo tariffRepo;

    @Autowired
    public TariffService(TariffRepo tariffRepo) {
        this.tariffRepo = tariffRepo;
    }

    public void saveTariff(final Tariff tariff) {
        tariffRepo.save(tariff);
    }
    public List<Tariff> getTariff() {
        return tariffRepo.findAll();
    }

    public Optional<Tariff> getTariffById(final Integer id) {
        return tariffRepo.findById(id);
    }

    public void deleteTariff(final Tariff tariff) {
        tariffRepo.delete(tariff);
    }
    public Page<Tariff> getTariffs(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return tariffRepo.findAll(pageable);
    }
}
