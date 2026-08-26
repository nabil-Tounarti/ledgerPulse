package com.ledgerpulse.infra.persistence.mapper;

import java.util.Currency;

import org.springframework.stereotype.Component;

import com.ledgerpulse.domain.model.Account;
import com.ledgerpulse.domain.model.AccountId;
import com.ledgerpulse.domain.model.Money;
import com.ledgerpulse.infra.persistence.entity.AccountEntityJpa;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountMapper {
  private final EntityManager entityManager;

  public AccountEntityJpa toNewEntity(Account account) {
    AccountEntityJpa entity = new AccountEntityJpa();
    entity.setId(account.getId().id());
    entity.setUserName(account.getUserName());
    entity.setBalance(account.getBalance().amount());
    entity.setCurrency(account.getBalance().currency().getCurrencyCode());
    return entity;
  }

  public AccountEntityJpa toOldEntity(Account account) {
    AccountEntityJpa entity = entityManager.getReference(AccountEntityJpa.class, account.getId().id());
    entity.setUserName(account.getUserName());
    entity.setBalance(account.getBalance().amount());
    entity.setCurrency(account.getBalance().currency().getCurrencyCode());
    return entity;
  }

  public Account toDomain(AccountEntityJpa accountEntityJpa) {
    return new Account(new AccountId(accountEntityJpa.getId()),
        new Money(accountEntityJpa.getBalance(), Currency.getInstance("EUR")), accountEntityJpa.getUserName());
  }
}
