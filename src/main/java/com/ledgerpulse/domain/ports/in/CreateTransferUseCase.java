package com.ledgerpulse.domain.ports.in;

import com.ledgerpulse.domain.model.Transfer;

public interface CreateTransferUseCase {
  void createTransfer(Transfer transfer);
}
