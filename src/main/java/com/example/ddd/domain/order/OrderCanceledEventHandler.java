package com.example.ddd.domain.order;

import com.example.ddd.application.order.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

// 이벤트를 처리할 핸들러
@Service
@RequiredArgsConstructor
public class OrderCanceledEventHandler {

    private final RefundService refundService;

    // 별도의 스레드로 비동기 실행 (외부 서비스 이슈 해결)
    @Async
    @EventListener(OrderCanceledEvent.class)
    // @TransactionalEventListener 를 사용하면 트랜잭션에 따라 해당 핸들러 메소드를 실행시킬지 말지 결정한다.
    // 따라서 이벤트 실패로 인한 트랜잭션 롤백에 대한 고민은 사라지고, 이벤트 재처리에 대한 고민만 고려해보면 된다.
    // @TransactionalEventListener(OrderCanceledEvent.class)
    public void handle(OrderCanceledEvent event) {
        refundService.refund(event.getOrderNumber());
    }
}
