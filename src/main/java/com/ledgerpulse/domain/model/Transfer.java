package com.ledgerpulse.domain.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import com.ledgerpulse.domain.events.*;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.ledgerpulse.domain.model.TransferId.newId;

@AllArgsConstructor
@Getter
public class Transfer {
  TransferId TransferId;
  AccountId sender;
  AccountId receiver;
  Money amount;
  TransferStatus status;
  Instant createdAt;

  public final List<DomainEvent> pendingEvents = new ArrayList<>();

  public Transfer initiate(Account sender, Account receiver, Money amount) {
    final Transfer t = new Transfer(newId(), sender.getId(), receiver.getId(),
        amount,
        TransferStatus.INITIATED,
        Instant.now());

    pendingEvents.add(new TransferInitiated(t.TransferId, t.sender, t.receiver, t.amount, t.createdAt));
    return t;
  }

  public void markFraudChecked() {
    requireStatus(TransferStatus.INITIATED);
  }

  public void markComplianceChecked() {
    requireStatus(TransferStatus.FRAUD_CHECKED);
  }

  public void complete() {
    requireStatus(TransferStatus.COMPLIANCE_CHECKED);
    pendingEvents.add(new TransferCompleted(this.TransferId, this.sender, this.receiver, this.amount, this.createdAt));
  }

  public void fail() {
    requireStatus(TransferStatus.COMPLIANCE_CHECKED);
    pendingEvents.add(new TransferRejected(this.TransferId, this.sender, this.createdAt));
  }

  private void requireStatus(TransferStatus status) {
    if (this.status.equals(status)) {
      throw new IllegalArgumentException("the requiredStatus is not satisfaying , i am in requireStatus function");
    }
  }

  public List<DomainEvent> pullEvents() {
    List<DomainEvent> events = List.copyOf(pendingEvents);
    events.clear();
    return events;
  }
}
