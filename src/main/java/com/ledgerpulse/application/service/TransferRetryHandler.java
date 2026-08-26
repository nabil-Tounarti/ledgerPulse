package com.ledgerpulse.application.service;

import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.ledgerpulse.application.command.CreateTransferCommand;
import com.ledgerpulse.application.dto.TransferResponse;

import lombok.AllArgsConstructor;

/**
 * TransferRetryHandler
 */
@Service
@AllArgsConstructor
public class TransferRetryHandler {
  private final CreateTransferService createTransferService;

  @Retryable(includes = ObjectOptimisticLockingFailureException.class, maxRetries = 4, delay = 20, multiplier = 2, jitter = 20)
  public TransferResponse transfer(CreateTransferCommand command) {
    return createTransferService.createTransfer(command);
  }
}
