package com.ledgerpulse.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ledgerpulse.domain.model.Account;
import com.ledgerpulse.domain.ports.in.GetAccountUseCase;
import com.ledgerpulse.domain.ports.out.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetAccountService implements GetAccountUseCase {

  final private AccountRepository accountRepository;

  @Override
  public Account getAccount(String username) {
    final Optional<Account> account = accountRepository.findByUserName(username);
    if (account.isPresent()) {
      return account.get();
    }
    throw new IllegalArgumentException("Account Not found");
  }
}
