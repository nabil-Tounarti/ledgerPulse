package com.ledgerpulse.domain.events;

import java.time.Instant;

/**
 * DomainEvent
 */
public sealed interface DomainEvent permits TransferInitiated, TransferCompleted, TransferRejected {
  Instant occurredAt();
}
