package com.ledgerpulse.infra.adapters.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ledgerpulse.application.command.CreateAccountCommand;
import com.ledgerpulse.application.dto.AccountDetailsResponse;
import com.ledgerpulse.application.dto.AccountResponse;
import com.ledgerpulse.application.request.CreateAccountRequest;
import com.ledgerpulse.domain.model.Account;
import com.ledgerpulse.domain.ports.in.CreateAccountUseCase;
import com.ledgerpulse.domain.ports.in.GetAccountUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

  private final CreateAccountUseCase createAccountUseCase;
  private final GetAccountUseCase getAccountUseCase;

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

  @GetMapping("/{username}")
  ResponseEntity<AccountDetailsResponse> getAccount(@PathVariable String username) {
    try {
      final Account account = getAccountUseCase.getAccount(username);
      final AccountDetailsResponse accountResponse = new AccountDetailsResponse(
          account.getUserName(),
          account.getBalance().amount());
      return ResponseEntity.status(HttpStatus.FOUND).body(accountResponse);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
