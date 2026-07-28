package com.ledgerpulse.domain.ports.in;

import jakarta.transaction.Transaction;

public interface CreateTransactionUseCase {
  void createTransaction(Transaction transaction);
}
