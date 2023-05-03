package com.example.ddd.domain.order;

import com.example.ddd.application.order.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

// 이벤트를 처리할 핸들러
@Service
@RequiredArgsConstructor
public class OrderCanceledEventHandler {

    private final RefundService refundService;

    // 별도의 스레드로 비동기 실행 (외부 서비스 이슈 해결)
    @Async
    @EventListener(OrderCanceledEvent.class)
    public void handle(OrderCanceledEvent event) {
        refundService.refund(event.getOrderNumber());
    }
}
