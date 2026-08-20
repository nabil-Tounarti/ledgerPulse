package com.ledgerpulse.domain.ports.out;

import com.ledgerpulse.domain.model.AccountId;

import java.util.Optional;

import com.ledgerpulse.domain.model.Account;

public interface AccountRepository {
  Optional<Account> findById(AccountId id);

  Optional<Account> findByUserName(String username);

  void save(Account account);
}
