package com.ledgerpulse.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * AccountDetailsResponse
 */
public record AccountDetailsResponse(UUID id, String username, BigDecimal balance) {

}
