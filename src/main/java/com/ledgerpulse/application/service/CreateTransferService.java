package com.ledgerpulse.application.service;

import org.springframework.stereotype.Service;

import com.ledgerpulse.application.command.CreateTransferCommand;
import com.ledgerpulse.application.dto.TransferResponse;
import com.ledgerpulse.domain.model.Account;
import com.ledgerpulse.domain.model.Transfer;
import com.ledgerpulse.domain.ports.in.CreateTransferUseCase;
import com.ledgerpulse.domain.ports.out.AccountRepository;
import com.ledgerpulse.domain.ports.out.TransferRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class CreateTransferService implements CreateTransferUseCase {
  final private AccountRepository accountRepository;
  final private TransferRepository transferRepository;

  @Override
  public TransferResponse createTransfer(CreateTransferCommand command) throws IllegalArgumentException {
    final Transfer transfer = new Transfer(command.sender(), command.reciever(), command.amount());
    final Account sender = accountRepository.findById(command.sender()).get();
    final Account receiver = accountRepository.findById(command.reciever()).get();
    try {
      sender.debit(command.amount());
      receiver.credit(command.amount());
    } catch (Exception e) {
      throw e;
    }
    accountRepository.update(sender);
    accountRepository.update(receiver);
    transferRepository.save(transfer);

    return new TransferResponse(transfer.getTransferId().id(), sender.getUserName(), receiver.getUserName(),
        command.amount().amount());

  }
}
