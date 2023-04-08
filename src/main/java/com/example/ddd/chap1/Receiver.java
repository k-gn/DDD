package com.example.ddd.chap1;

import lombok.Getter;

@Getter
public class Receiver {

    private String name;
    private String phoneNumber;

    public Receiver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
