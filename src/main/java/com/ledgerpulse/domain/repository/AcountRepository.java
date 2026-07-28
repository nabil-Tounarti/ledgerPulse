package com.ledgerpulse.domain.repository;

import java.util.Optional;

import com.ledgerpulse.domain.model.Account;
import com.ledgerpulse.domain.model.AccountId;

public interface AcountRepository {
  Optional<Account> findById(AccountId id);

  void save(Account account);
}
