package com.ledgerpulse.infra.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ledgerpulse.infra.persistence.entity.AccountEntityJpa;

public interface JpaAccountRepository extends JpaRepository<AccountEntityJpa, UUID> {

}
