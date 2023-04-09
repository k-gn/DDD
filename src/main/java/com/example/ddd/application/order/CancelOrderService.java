package com.example.ddd.application.order;

import com.example.ddd.application.order.exception.NoOrderException;
import com.example.ddd.domain.order.Order;
import com.example.ddd.domain.order.OrderNo;
import com.example.ddd.domain.order.OrderRepository;

public class CancelOrderService {

    private OrderRepository orderRepository;

    public void cancel(OrderNo number) {
        Order order = orderRepository.findByNumber(number);
        if (order == null) throw new NoOrderException(number);
        order.cancel();
    }
}
