package com.ledgerpulse.application.service;

import java.math.BigDecimal;
import java.util.Currency;

import org.springframework.stereotype.Service;

import com.ledgerpulse.application.command.CreatAccountCommand;
import com.ledgerpulse.application.dto.AccountResponse;
import com.ledgerpulse.domain.model.Account;
import com.ledgerpulse.domain.model.AccountId;
import com.ledgerpulse.domain.model.Money;
import com.ledgerpulse.domain.ports.in.CreateAccountUseCase;
import com.ledgerpulse.domain.ports.out.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateAccountService implements CreateAccountUseCase {
  private final AccountRepository accountRepository;

  @Override
  public AccountResponse createAccount(CreatAccountCommand command) {
    Money ammount = new Money(BigDecimal.ZERO, Currency.getInstance("EUR"));
    Account account = new Account(AccountId.newId(), ammount, command.userName());
    accountRepository.save(account);
    return new AccountResponse(account.getId().id(), account.getUserName(), account.getBalance().amount());
  }

}
