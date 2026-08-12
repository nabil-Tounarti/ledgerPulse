package com.ledgerpulse.infra.adapters.out;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ledgerpulse.domain.model.Transfer;
import com.ledgerpulse.domain.model.TransferId;
import com.ledgerpulse.domain.ports.out.TransferRepository;
import com.ledgerpulse.infra.persistence.entity.TransferEntityJpa;
import com.ledgerpulse.infra.persistence.mapper.TransferMapper;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class TransferRepositoryAdapter implements TransferRepository {

  private final JpaRepository<TransferEntityJpa, UUID> transferRepository;
  private final TransferMapper transferMapper;

  @Override
  public Optional<Transfer> findById(TransferId id) {
    final TransferEntityJpa transferEntityJpa = transferRepository.findById(id.id()).get();

    return Optional.of(transferMapper.toDomain(transferEntityJpa));
  }

  @Override
  public void save(Transfer transfer) {
    transferRepository.save(transferMapper.toEntity(transfer));
  }

}
