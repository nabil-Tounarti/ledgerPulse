package com.ledgerpulse.domain.ports.out;

import com.ledgerpulse.domain.model.AccountId;
import com.ledgerpulse.domain.model.Money;

public interface FraudCheckPort {
  boolean isSuspicious(AccountId sender, Money amount);
}
