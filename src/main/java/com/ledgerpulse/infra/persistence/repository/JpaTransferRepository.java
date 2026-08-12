package com.ledgerpulse.infra.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ledgerpulse.infra.persistence.entity.TransferEntityJpa;

public interface JpaTransferRepository extends JpaRepository<TransferEntityJpa, UUID> {

}
