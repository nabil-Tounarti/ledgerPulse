package com.ledgerpulse.domain;

import com.ledgerpulse.domain.model.Account;
import com.ledgerpulse.domain.model.Transfer;
import com.ledgerpulse.domain.ports.in.CreateAccountUseCase;
import com.ledgerpulse.domain.ports.in.CreateTransferUseCase;
import com.ledgerpulse.domain.ports.out.AccountRepository;
import com.ledgerpulse.domain.ports.out.TransferRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransferServiceDomain
    implements CreateTransferUseCase, CreateAccountUseCase {
  final private AccountRepository accountRepository;
  final private TransferRepository TransferRepository;

  @Override
  public void createTransfer(Transfer transfer) {
    this.TransferRepository.save(transfer);
  }

  @Override
  public void createAccount(Account account) {
    this.accountRepository.save(account);
  }
}
