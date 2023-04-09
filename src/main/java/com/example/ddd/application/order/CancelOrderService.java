package com.example.ddd.application.order;

import com.example.ddd.application.order.exception.NoOrderException;
import com.example.ddd.domain.order.Order;
import com.example.ddd.domain.order.OrderNo;
import com.example.ddd.domain.order.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

public class CancelOrderService {

    private OrderRepository orderRepository;

    @Transactional // 응용 서비스는 트랜잭션을 관리한다.
    public void cancel(OrderNo number) {
        Order order = orderRepository.findByNumber(number);
        if (order == null) throw new NoOrderException(number);
        order.cancel();
    }
}
