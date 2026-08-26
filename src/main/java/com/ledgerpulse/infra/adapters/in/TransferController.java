package com.ledgerpulse.infra.adapters.in;

import com.ledgerpulse.application.command.CreateTransferCommand;
import com.ledgerpulse.application.dto.TransferResponse;
import com.ledgerpulse.application.request.TransferRequest;
import com.ledgerpulse.application.service.TransferRetryHandler;
import com.ledgerpulse.domain.model.AccountId;
import com.ledgerpulse.domain.model.Money;

import java.util.Currency;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transfer")
public class TransferController {
  private final TransferRetryHandler transferRetryHandler;

  @PostMapping
  ResponseEntity<TransferResponse> createTransfer(@RequestBody TransferRequest request) {
    final CreateTransferCommand command = new CreateTransferCommand(new AccountId(request.sourceAcountId()),
        new AccountId(request.destenatioAccountId()),
        new Money(request.amount(), Currency.getInstance(request.currency())));
    try {
      final TransferResponse transferResponse = transferRetryHandler.transfer(command);
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(transferResponse);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
    }
  }
}
