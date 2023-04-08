package com.example.ddd.chap1;

public enum OrderState {
	// 도메인에서 사용하는 용어를 정의하는게 좋다.
	// 가독성을 높이고, 코드를 분석하고 이해하는 시간을 줄여주며, 용어의 모호함과 불필요한 해석과정을 줄일 수 있다.
	PAYMENT_WAITING,
	PREPARING,
	SHIPPED,
	DELIVERING,
	DELIVERY_COMPLETED,
	CANCELED
}
