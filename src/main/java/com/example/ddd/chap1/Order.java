package com.example.ddd.chap1;

import java.util.List;
import java.util.Objects;

/*
	# 주문
 */
public class Order {

	private String orderNumber; // 식별자
	private List<OrderLine> orderLines;
	private Money totalAmounts;
	private ShippingInfo shippingInfo;
	private OrderState orderState;

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
		return Objects.equals(orderNumber, order.orderNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderNumber);
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
		int sum = orderLines.stream().mapToInt(OrderLine::getAmounts).sum();
		this.totalAmounts = new Money(sum);
	}

	public void changeShipped() {

	}

	public void changeShippingInfo(ShippingInfo newShippingInfo) {
		verifyNotYetShipped();
		setShippingInfo(newShippingInfo);
	}

	/*
		배송지 변경이나, 주문 취소 기능은 출고 전에만 가능하다.
	 */
	private void verifyNotYetShipped() {
		if (orderState != OrderState.PAYMENT_WAITING && orderState != OrderState.PREPARING) {
			throw new IllegalArgumentException("already shipped");
		}
	}

	public void cancel() {
		verifyNotYetShipped();
		this.orderState = OrderState.CANCELED;
	}

	public void completePayment() {

	}
}
