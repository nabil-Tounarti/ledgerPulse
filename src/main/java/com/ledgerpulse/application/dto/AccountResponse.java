package com.ledgerpulse.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * CreateAccountResponse
 */
public record AccountResponse(UUID id, String userName, BigDecimal ammount) {

}
