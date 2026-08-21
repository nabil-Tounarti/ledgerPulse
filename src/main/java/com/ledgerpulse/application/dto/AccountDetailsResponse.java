package com.ledgerpulse.application.dto;

import java.math.BigDecimal;

/**
 * AccountDetailsResponse
 */
public record AccountDetailsResponse(String username, BigDecimal balance) {

}
