package com.ledgerpulse.application.command;

import com.ledgerpulse.domain.model.AccountId;
import com.ledgerpulse.domain.model.Money;

/**
 * CreateTransferCommand
 */
public record CreateTransferCommand(AccountId sender, AccountId reciever, Money amount) {

}
