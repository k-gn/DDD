package com.example.ddd.domain.order;

/*
    애그리거트 단위로 루트 도메인 객체를 저장/조회할 레포지토리
 */
public interface OrderRepository {

    Order findByNumber(OrderNo number);

    void save(Order order);

    void delete(Order order);
}
