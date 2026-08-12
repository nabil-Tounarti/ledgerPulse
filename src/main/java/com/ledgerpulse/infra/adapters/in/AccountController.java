package com.ledgerpulse.infra.adapters.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ledgerpulse.application.command.CreateAccountCommand;
import com.ledgerpulse.application.dto.AccountResponse;
import com.ledgerpulse.domain.ports.in.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

  private final CreateAccountUseCase createAccountUseCase;

  @PostMapping
  public ResponseEntity<AccountResponse> createAccount(
      @RequestBody CreateAccountRequest request) {

    CreateAccountCommand command = new CreateAccountCommand(
        request.username());

    AccountResponse response = createAccountUseCase.createAccount(command);

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(response);
  }
}
