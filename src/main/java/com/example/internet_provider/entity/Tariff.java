package com.example.internet_provider.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private int speed;
    @OneToOne
    private Subscriber subscriber;

}
