package com.ledgerpulse.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * TransferResponse
 */
public record TransferResponse(UUID id, String senderName, String recieverName, BigDecimal amount) {

}
