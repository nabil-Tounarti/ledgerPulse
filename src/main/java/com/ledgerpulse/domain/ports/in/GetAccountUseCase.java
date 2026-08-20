package com.ledgerpulse.domain.ports.in;

import com.ledgerpulse.domain.model.Account;

public interface GetAccountUseCase {
  Account getAccount(String username);
}
