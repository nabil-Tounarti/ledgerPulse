
package com.ledgerpulse.domain.ports.in;

import com.ledgerpulse.application.command.CreatAccountCommand;
import com.ledgerpulse.application.dto.AccountResponse;

public interface CreateAccountUseCase {
  AccountResponse createAccount(CreatAccountCommand command);
}
