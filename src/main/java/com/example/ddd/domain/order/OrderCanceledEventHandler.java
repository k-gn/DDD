package com.example.ddd.domain.order;

import com.example.ddd.application.order.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

// 이벤트를 처리할 핸들러
@Service
@RequiredArgsConstructor
public class OrderCanceledEventHandler {

    private final RefundService refundService;

    @EventListener(OrderCanceledEvent.class)
    public void handle(OrderCanceledEvent event) {
        refundService.refund(event.getOrderNumber());
    }
}
