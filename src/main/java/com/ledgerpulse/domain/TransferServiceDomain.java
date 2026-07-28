package com.ledgerpulse.domain;

import com.ledgerpulse.domain.ports.in.CreateTransactionUseCase;

import jakarta.transaction.Transaction;

public class TransferServiceDomain
    implements CreateTransactionUseCase {

  @Override
  public void createTransaction(Transaction transaction) {

  }

}
