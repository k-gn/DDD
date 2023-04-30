package com.example.ddd.domain;

import com.example.ddd.domain.order.Money;
import com.example.ddd.domain.order.OrderLine;

import java.util.List;

/*
    # 도메인 서비스
    - 도메인 영역에 위치한 도메인 로직을 표현할 때 사용함
    - 애그리거트에 위치하기 애매한 로직들
        - 복잡한 계산 로직
        - 외부 시스템 연동 로직
        - 권한 검증
        - ...
    - 즉, 애그리거트의 값/상태를 변경하고 사용하는 도메인 로직이면서 한 애그리거트에 넣기 적합하지 않은 경우 도메인 서비스로 구현한다.

    - 응용 서비스가 도메인 서비스를 사용할수도, 애그리거트가 사용할수도 있다.
        - 애그리거트가 사용하기 위해선 응용 서비스가 도메인 서비스를 전달해주어야 한다.
    - 반대로 도메인 서비스 기능을 실행할 때 애그리거트를 인자로 전달하기도 한다.
        - 애그리거트를 인자로 전달하는 행위는 응용 서비스가 한다.

    - 트랜잭션 처리같은 응용 로직은 도메인 서비스에서 하지 않는다.

    - 도메인 서비스를 애그리거트에서 주입받으면 안된다.
        - 도메인 객체는 하나의 데이터 모델인데, 도메인 서비스는 데이터와 관련이 없음
        - 도메인 객체의 일부 기능을 위해 굳이 의존 주입을 할 이유도 없음

    - 도메인 서비스의 위치는 다른 도메인 구성요소와 동일한 패키지에 위치한다.
        - 주문 금액 계산을 위한 도메인 서비스는 주문 애그리거트와 같은 패키지에 위치한다.
        - 개수가 많거나, 명시적으로 구분하고 싶다면 같은 domain 패키지에 하위 패키지를 생성해 구분한다.
        - 도메인 서비스의 구현이 특정 기술에 종속될 경우 인터페이스로 추상화한 후 구현 클래스를 infrastructure 영역에 생성한다.
 */
public class DiscountCalculationService {

    public Money calculateDiscountAmounts(
        List<OrderLine> orderLines,
        List<Coupon> coupons,
        MemberGrade grade
    ) {
        int value = 0;
        // ... 계산 로직
        return new Money(value);
    }
}
