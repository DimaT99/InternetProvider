package com.example.internet_provider.config;

import com.example.internet_provider.entity.Tariff;
import com.example.internet_provider.service.TariffService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class DbInit {

    private final TariffService tariffService;

    private Random random = new Random();
    public DbInit(final TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @PostConstruct
    private void postConstruct() {
        for (int i = 0; i < 10; i++) {
            final Tariff tariff = new Tariff() ;
            tariff.setName("Tariff " + random.nextInt(1, 15));
            tariff.setSpeed(random.nextInt(90, 100));
            tariff.setPrice(random.nextDouble(200, 300));
            tariffService.saveTariff(tariff);
        }
    }
}
