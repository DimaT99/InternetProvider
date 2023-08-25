package com.example.internet_provider.controller;

import com.example.internet_provider.entity.Tariff;
import com.example.internet_provider.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class TariffController {

    private TariffService tariffService;

    @Autowired
    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping("/tariffs")
    public String getBooks(Model model) {
        final List<Tariff> tariffs = tariffService.getTariff();
        model.addAttribute("tariffs", tariffs);
        return "all-tariffs";
    }

    @GetMapping("/tariffs/{id}")
    public String getTariffs(Model model, @PathVariable Integer id) {
        final Optional<Tariff> tariffById = tariffService.getTariffById(id);
        final Tariff tariff = tariffById.orElse(null);
        model.addAttribute("tariff", tariff);
        model.addAttribute("id", id);
        return "tariff";
    }

    @GetMapping("/tariff")
    public String formForTree(Model model) {
        return "tariffserv";
    }

    @PostMapping("/add")
    public String addTariff(@Valid Tariff tariff) {
        tariffService.saveTariff(tariff);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String postEditTariff(@PathVariable Integer id,
                               Model model,
                               Tariff tariff) {
        final Optional<Tariff> tariffById = tariffService.getTariffById(id);

        if (tariffById.isEmpty()) {
            throw new IllegalStateException();
        }

        final Tariff tariff1 = tariffById.get();
        tariff1.setName(tariff.getName());
        tariff1.setSpeed(tariff.getSpeed());
        tariff1.setPrice(tariff.getPrice());

        tariffService.saveTariff(tariff1);

        return "redirect:/";
    }

    @GetMapping("/tariffs/delete/{id}")
    public String deleteTree(Model model, @PathVariable Integer id) {
        final Optional<Tariff> tariffById = tariffService.getTariffById(id);
        final Tariff tariff = tariffById.orElse(null);
        tariffService.deleteTariff(tariff);
        return "redirect:/";
    }

}
