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
  private TransferId transferId;
  private AccountId sender;
  private AccountId receiver;
  private Money amount;
  private TransferStatus status;
  private Instant createdAt;

  private final List<DomainEvent> pendingEvents = new ArrayList<>();

  public Transfer(AccountId sender, AccountId receiver, Money amount) {
    this.transferId = newId();
    this.sender = sender;
    this.receiver = receiver;
    this.amount = amount;
    this.status = TransferStatus.INITIATED;
    this.createdAt = Instant.now();

    this.pendingEvents
        .add(new TransferInitiated(this.transferId, this.sender, this.receiver, this.amount, this.createdAt));
  }

  public void markFraudChecked() {
    requireStatus(TransferStatus.INITIATED);
    this.status = TransferStatus.FRAUD_CHECKED;
  }

  public void markComplianceChecked() {
    requireStatus(TransferStatus.FRAUD_CHECKED);
    this.status = TransferStatus.COMPLIANCE_CHECKED;
  }

  public void complete() {
    requireStatus(TransferStatus.COMPLIANCE_CHECKED);
    this.status = TransferStatus.COMPLETED;
    pendingEvents.add(new TransferCompleted(this.transferId, this.sender, this.receiver, this.amount, this.createdAt));
  }

  public void fail() {
    requireStatus(TransferStatus.COMPLIANCE_CHECKED);
    this.status = TransferStatus.REJECTED;
    pendingEvents.add(new TransferRejected(this.transferId, this.sender, this.createdAt));
  }

  private void requireStatus(TransferStatus status) {
    if (!this.status.equals(status)) {
      throw new IllegalArgumentException("the requiredStatus is not satisfaying , i am in requireStatus function");
    }
  }

  public List<DomainEvent> pullEvents() {
    List<DomainEvent> events = List.copyOf(pendingEvents);
    pendingEvents.clear();
    return events;
  }
}
