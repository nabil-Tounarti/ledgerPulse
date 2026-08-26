package com.ledgerpulse.infra.adapters.out;

import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.ledgerpulse.domain.model.Account;
import com.ledgerpulse.domain.model.AccountId;
import com.ledgerpulse.domain.ports.out.AccountRepository;
import com.ledgerpulse.infra.persistence.mapper.AccountMapper;
import com.ledgerpulse.infra.persistence.repository.JpaAccountRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AccountRepositoryAdapter implements AccountRepository {

  private final JpaAccountRepository accountRepository;
  private final AccountMapper accountMapper;

  @Override
  public Optional<Account> findById(AccountId id) {
    return Optional.of(accountMapper.toDomain(accountRepository.findById(id.id()).get()));
  }

  @Override
  public void save(Account account) {
    accountRepository.save(accountMapper.toNewEntity(account));
  }

  @Override
  public void update(Account account) {
    accountRepository.save(accountMapper.toOldEntity(account));
  }

  @Override
  public Optional<Account> findByUserName(String username) {
    return Optional.of(accountMapper.toDomain(accountRepository.findByUserName(username).get()));
  }

}
