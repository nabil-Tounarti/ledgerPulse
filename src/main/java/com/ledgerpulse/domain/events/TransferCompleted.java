package com.ledgerpulse.domain.events;

import java.time.Instant;

import com.ledgerpulse.domain.model.AccountId;
import com.ledgerpulse.domain.model.Money;
import com.ledgerpulse.domain.model.TransferId;

/**
 * TransferCompleted
 */
public record TransferCompleted(TransferId transferId, AccountId sender, AccountId receiver,
    Money amount, Instant occurredAt) implements DomainEvent {

}
