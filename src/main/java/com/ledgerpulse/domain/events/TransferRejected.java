package com.ledgerpulse.domain.events;

import java.time.Instant;

import com.ledgerpulse.domain.model.TransferId;

/**
 * TransferRejected
 */
public record TransferRejected(TransferId transferId, String sender, Instant occurredAt) implements DomainEvent {

}
