package com.example.ddd.domain.order;

import com.example.ddd.domain.Event;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class OrderCanceledEvent extends Event {

    private String orderNumber;

    public String getOrderNumber() {
        return orderNumber;
    }
}
