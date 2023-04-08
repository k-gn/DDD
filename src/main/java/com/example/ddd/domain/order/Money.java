package com.example.ddd.domain.order;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Money {

	private final int value;

	public Money(int value) {
		this.value = value;
	}

	public Money add(Money money) {
		return new Money(this.value + money.getValue());
	}

	public Money multiply(int multiplier) {
		return new Money(this.value * multiplier);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Money money = (Money) o;
		return value == money.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
