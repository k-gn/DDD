package com.example.ddd.chap1;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Receiver {

    private String name;
    private String phoneNumber;

    public Receiver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receiver receiver = (Receiver) o;
        return Objects.equals(name, receiver.name) && Objects.equals(phoneNumber, receiver.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}
