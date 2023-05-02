package com.example.ddd.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 배송지 변경 시 발생하는 이벤트 클래스
// 이벤트는 현재 기준으로 과거에 벌어진 것을 표현하기 때문에 과거 시제를 사용한다.
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShippingInfoChangedEvent {

    private String orderNumber;
    private long timestamp;
    private ShippingInfo newShippingInfo;
}
