package com.example.ddd.application.order.exception;

import com.example.ddd.domain.order.OrderNo;

public class NoOrderException extends RuntimeException {

    public NoOrderException(OrderNo number) {
        super("no order by " + number);
    }
}
