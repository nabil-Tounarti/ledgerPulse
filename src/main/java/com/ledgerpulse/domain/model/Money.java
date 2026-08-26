package com.ledgerpulse.domain.model;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Money
 */

public record Money(BigDecimal amount, Currency currency) {
  public Money {
    if (amount == null || currency == null) {
      throw new IllegalArgumentException("the amount or the currency are null");
    }
  }

  public static Money of(String amount, String currency) {
    return new Money(new BigDecimal(amount), Currency.getInstance(currency));
  }

  public Money add(Money other) {
    requireSameCurrency(other);
    return new Money(this.amount.add(other.amount), this.currency);
  }

  public Money subtract(Money other) {
    requireSameCurrency(other);
    return new Money(this.amount.subtract(other.amount), this.currency);
  }

  public boolean isGreaterThanOrEqual(Money other) {
    requireSameCurrency(other);
    return this.amount.compareTo(other.amount) >= 0;
  }

  private void requireSameCurrency(Money other) {
    if (!this.currency.equals(other.currency)) {
      throw new UnsupportedOperationException("the accounts dont have the same currency");
    }
  }

}
