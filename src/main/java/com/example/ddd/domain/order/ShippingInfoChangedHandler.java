package com.example.ddd.domain.order;

import org.springframework.context.event.EventListener;

// ShippingInfoChangedEvent 를 처리하는 핸들러
public class ShippingInfoChangedHandler {

    @EventListener(ShippingInfoChangedEvent.class)
    public void handle(ShippingInfoChangedEvent event) {
        // ...
    }
}
