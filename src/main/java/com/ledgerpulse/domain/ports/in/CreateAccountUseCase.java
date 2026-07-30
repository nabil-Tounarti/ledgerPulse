
package com.ledgerpulse.domain.ports.in;

import com.ledgerpulse.domain.model.Account;

public interface CreateAccountUseCase {
  void createAccount(Account account);
}
