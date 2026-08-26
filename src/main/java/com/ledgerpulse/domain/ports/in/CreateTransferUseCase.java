package com.ledgerpulse.domain.ports.in;

import com.ledgerpulse.application.command.CreateTransferCommand;
import com.ledgerpulse.application.dto.TransferResponse;

public interface CreateTransferUseCase {
  TransferResponse createTransfer(CreateTransferCommand command);
}
