package com.ledgerpulse.infra.persistence.mapper;

import java.util.Currency;

import org.springframework.stereotype.Component;

import com.ledgerpulse.domain.model.AccountId;
import com.ledgerpulse.domain.model.Money;
import com.ledgerpulse.domain.model.Transfer;
import com.ledgerpulse.domain.model.TransferId;
import com.ledgerpulse.infra.persistence.entity.AccountEntityJpa;
import com.ledgerpulse.infra.persistence.entity.TransferEntityJpa;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransferMapper {
  private final EntityManager entityManager;

  public TransferEntityJpa toEntity(Transfer transfer) {
    TransferEntityJpa entity = new TransferEntityJpa();
    entity.setId(transfer.getTransferId().id());
    entity.setSender(entityManager.getReference(AccountEntityJpa.class, transfer.getSender().id()));
    entity.setReciever(entityManager.getReference(AccountEntityJpa.class, transfer.getReceiver().id()));
    entity.setAmount(transfer.getAmount().amount());
    entity.setCreatedAt(transfer.getCreatedAt());
    entity.setTransferStatus(transfer.getStatus());
    return entity;
  }

  public Transfer toDomain(TransferEntityJpa transferJpa) {
    return new Transfer(new TransferId(transferJpa.getId()),
        new AccountId(transferJpa.getSender().getId()),
        new AccountId(transferJpa.getReciever().getId()),
        new Money(transferJpa.getAmount(), Currency.getInstance("EUR")),
        transferJpa.getTransferStatus(),
        transferJpa.getCreatedAt());
  }
}
