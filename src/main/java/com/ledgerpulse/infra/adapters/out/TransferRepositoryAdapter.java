package com.ledgerpulse.infra.adapters.out;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ledgerpulse.domain.model.Transfer;
import com.ledgerpulse.domain.model.TransferId;
import com.ledgerpulse.domain.ports.out.TransferRepository;
import com.ledgerpulse.infra.persistence.entity.TransferEntityJpa;
import com.ledgerpulse.infra.persistence.mapper.TransferMapper;
import com.ledgerpulse.infra.persistence.repository.JpaTransferRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class TransferRepositoryAdapter implements TransferRepository {

  private final JpaTransferRepository transferRepository;
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
