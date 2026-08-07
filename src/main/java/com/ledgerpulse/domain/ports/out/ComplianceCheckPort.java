package com.ledgerpulse.domain.ports.out;

import com.ledgerpulse.domain.model.AccountId;

public interface ComplianceCheckPort {
  boolean isBlocked(AccountId sender, AccountId reciever);
}
