package com.example.ddd.domain.order;

import java.util.Optional;

/*
    애그리거트 단위로 루트 도메인 객체를 저장/조회할 레포지토리
    해당 클래스는 도메인 객체를 영속화하는데 필요한 기능을 추상화한 고수준 모듈

    저수준 모듈인 구현 클래스는 인프라스트럭처 영역에 속한다. (DIP)

    DIP의 장점을 해치치 않는 범위에서 응용 영역과 도메인 영역에서 구현 기술에 대한 의존을 가져가는 건 나쁘지 않다.
 */
public interface OrderRepository {

    Optional<Order> findById(OrderNo no);

    Order findByNumber(OrderNo no);

    void save(Order order);

    void delete(Order order);
}
