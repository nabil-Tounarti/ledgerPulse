package com.ledgerpulse.domain.events;

import java.time.Instant;

import com.ledgerpulse.domain.model.AccountId;
import com.ledgerpulse.domain.model.TransferId;

/**
 * TransferRejected
 */
public record TransferRejected(TransferId transferId, AccountId sender, Instant occurredAt) implements DomainEvent {

}
