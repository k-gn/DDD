package com.example.ddd.domain.order;

import java.util.List;
import java.util.Objects;

import static com.example.ddd.domain.order.OrderState.*;

/*
	# 주문

	- setter 는 지양하는게 좋다. (private 으로 선언 후 생성자와 같은 내부에서 사용 및 검증하는 방식은 괜찮다.)

	- 도메인이 커질수록 엔티티와 밸류 개수가 많아지고 복잡해진다. -> 개발자가 전체 구조가 아닌 개별 엔티티와 밸류 객체에 집중하는 상황이 생긴다.
	- 전체 상위 수준에서 모델을 볼 수 있어야 전체 모델과 개별 모델을 이해하는데 도움이 된다.

	## 도메인 모델에서 전체 구조를 이해하는데 도움이 되는 것이 애그리거트다.
	- 애그리거트는 관련된 객체를 하나로 묶은 군집.
	- 군집에 속한 객체를 관리하고 기능을 제공하는 루트 엔티티를 갖는다.
	- 주문 도메인의 애그리거트 루트는 Order 클래스.
	- 해당 클래스를 거쳐 간접적으로 애그리거트 내의 엔티티나 밸류 객체에 접근할 수 있다.
	- 즉, 내부구현을 숨겨서 애그리거트 단위로 구현을 캡슐화 할 수 있다.
		- ex) 배송지를 변경하려면 Order 클래스를 통해 변경할 수 있다. (항상 Order가 구현한 도메인 로직을 따른다)

	## 애그리거트 루트 클래스
	- 애그리거트 루트를 통해서만 도메인 로직을 구현한다.
		- public setter (x)
		- 밸류타입을 불변으로

 */
// @Entity
//@Table(name = "TBL_ORDER")
public class Order {

	private OrderNo number; // 식별자, OrderNo 라는 밸류타입으로 선언할 수 있다.
	private List<OrderLine> orderLines;
	private Money totalAmounts;
	private ShippingInfo shippingInfo;
	private OrderState orderState;
	private Orderer orderer;

	public Order(
		List<OrderLine> orderLines,
		ShippingInfo shippingInfo
	) {
		setOrderLines(orderLines);
		setShippingInfo(shippingInfo);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Objects.equals(this.number.getId(), order.number.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(number.getId());
	}

	private void setShippingInfo(ShippingInfo shippingInfo) {
		if (shippingInfo == null) {
			throw new IllegalArgumentException("no ShippingInfo");
		}

		this.shippingInfo = shippingInfo;
	}

	private void setOrderLines(List<OrderLine> orderLines) {
		if (orderLines == null || orderLines.isEmpty()) {
			throw new IllegalArgumentException("no OrderLine");
		}

		this.orderLines = orderLines;
		calculateTotalAmounts();
	}

	private void calculateTotalAmounts() {
		int sum = orderLines.stream()
				.mapToInt(m -> m.getPrice().getValue() * m.getQuantity()).sum();
		this.totalAmounts = new Money(sum);
	}

	public void changeShipped() {
		this.orderState = SHIPPED;
	}

	public void changeShippingInfo(ShippingInfo newShippingInfo) {
		verifyNotYetShipped();
		setShippingInfo(newShippingInfo);
	}

	/*
		배송지 변경이나, 주문 취소 기능은 출고 전에만 가능하다.
	 */
	private void verifyNotYetShipped() {
		if (orderState != PAYMENT_WAITING && orderState != PREPARING) {
			throw new IllegalArgumentException("already shipped");
		}
	}

	public void cancel() {
		verifyNotYetShipped();
		this.orderState = CANCELED;
	}

	public void completePayment() {

	}
}
