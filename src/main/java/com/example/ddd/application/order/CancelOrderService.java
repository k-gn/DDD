package com.example.ddd.application.order;

import com.example.ddd.application.order.exception.NoOrderException;
import com.example.ddd.domain.order.Order;
import com.example.ddd.domain.order.OrderNo;
import com.example.ddd.domain.order.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

public class CancelOrderService {

    private OrderRepository orderRepository;
    private RefundService refundService;

    @Transactional // 응용 서비스는 트랜잭션을 관리한다.
    public void cancel(OrderNo number) {
        Order order = orderRepository.findByNumber(number);
        if (order == null) throw new NoOrderException(number);
        order.cancel();

        /*
            - 환불 로직이 외부 시스템과 연동되어 있다고 가정할 때 여러 문제가 있다.
                1. 트랜잭션 롤백 기준
                2. 응답 성능
                3. 주문 취소 로직과 결제 취소(환불) 로직이 섞임 (주문 바운디드와 결제 바운디드가 강결합 된다)

            - 이런 강결합을 없애기 위해 이벤트 + 비동기를 사용한다.
         */
        refundService.refund();
    }
}
