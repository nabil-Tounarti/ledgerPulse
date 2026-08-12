
package com.ledgerpulse.domain.ports.in;

import com.ledgerpulse.application.command.CreateAccountCommand;
import com.ledgerpulse.application.dto.AccountResponse;

public interface CreateAccountUseCase {
  AccountResponse createAccount(CreateAccountCommand command);
}
