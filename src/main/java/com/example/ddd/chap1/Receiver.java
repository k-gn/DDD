package com.example.ddd.chap1;

import lombok.Getter;

import java.util.Objects;

// 밸류 객체는 명확한 표현과, 자체 기능을 제공한다.
@Getter
public class Receiver {

    private String name;
    private String phoneNumber;

    public Receiver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // 밸류객체 비교 시 모든 속성이 같은지 비교
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
