package com.ledgerpulse.domain.model;

import lombok.Getter;

@Getter
public class Account {

  private final AccountId id;
  private Money balance;
  private final String userName;

  public Account(AccountId id, Money balance, String userName) {
    this.id = id;
    this.balance = balance;
    this.userName = userName;
  }

  // Business invariant lives HERE, not in a service — this is what makes it DDD
  // rather than an anemic model. The aggregate is the only thing allowed to
  // mutate its own balance, and it refuses invalid state transitions.
  public void debit(Money amount) throws IllegalArgumentException {
    if (!balance.isGreaterThanOrEqual(amount)) {
      throw new IllegalArgumentException(
          String.format("Insufficient funds: id=%s, amount=%s, balance=%s", id, amount, balance));
    }
    balance = balance.subtract(amount);
  }

  public void credit(Money amount) {
    balance = balance.add(amount);
  }

}
