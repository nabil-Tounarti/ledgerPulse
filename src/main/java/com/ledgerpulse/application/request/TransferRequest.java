package com.ledgerpulse.application.request;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * TransferRequest
 */
public record TransferRequest(UUID sourceAcountId, UUID destenatioAccountId, BigDecimal amount, String currency) {

}
