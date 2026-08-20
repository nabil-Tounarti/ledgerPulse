package com.ledgerpulse.infra.adapters.in;

import java.math.BigDecimal;

/**
 * AccountDetailsResponse
 */
public record AccountDetailsResponse(String username, BigDecimal balance) {

}
