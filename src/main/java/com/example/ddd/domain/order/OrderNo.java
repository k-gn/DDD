package com.example.ddd.domain.order;

import lombok.Getter;

@Getter
public class OrderNo {

    private String id;

    public OrderNo(String id) {
        this.id = id;
    }
}
