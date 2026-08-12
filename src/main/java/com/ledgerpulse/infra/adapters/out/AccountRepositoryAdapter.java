package com.ledgerpulse.infra.adapters.out;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ledgerpulse.domain.model.Account;
import com.ledgerpulse.domain.model.AccountId;
import com.ledgerpulse.domain.ports.out.AccountRepository;
import com.ledgerpulse.infra.persistence.entity.AccountEntityJpa;
import com.ledgerpulse.infra.persistence.mapper.AccountMapper;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AccountRepositoryAdapter implements AccountRepository {

  private final JpaRepository<AccountEntityJpa, UUID> accountRepository;
  private final AccountMapper accountMapper;

  @Override
  public Optional<Account> findById(AccountId id) {
    return Optional.of(accountMapper.toDomain(accountRepository.findById(id.id()).get()));
  }

  @Override
  public void save(Account account) {
    accountRepository.save(accountMapper.toEntity(account));
  }

}
