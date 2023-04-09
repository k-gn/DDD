package com.example.ddd.domain.order;

import lombok.Getter;

@Getter
public class Orderer {

    private String name;
    private String email;

    public Orderer(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
