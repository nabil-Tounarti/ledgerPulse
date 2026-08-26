package com.ledgerpulse.domain.model;

import java.util.UUID;

/**
 * TransferId
 */
public record TransferId(UUID id) {
  public static TransferId newId() {
    return new TransferId(UUID.randomUUID());
  }
}
