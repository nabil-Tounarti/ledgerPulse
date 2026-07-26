package com.ledgerpulse.domain.model;

import java.util.UUID;

/**
 * AccountId
 */
public record AccountId(UUID id) {
  public static AccountId newId() {
    return new AccountId(UUID.randomUUID());
  }
}
