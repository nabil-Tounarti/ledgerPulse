package com.ledgerpulse.domain.ports.in;

import com.ledgerpulse.application.dto.AccountDetailsResponse;

public interface GetAccountUseCase {
  AccountDetailsResponse getAccount(String username);
}
