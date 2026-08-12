package com.ledgerpulse.infra.persistence.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import com.ledgerpulse.domain.model.TransferStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TransferEntityJpa {
  @Id
  @Column(name = "id")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "sender_id")
  private AccountEntityJpa sender;

  @ManyToOne
  @JoinColumn(name = "reciever_id")
  private AccountEntityJpa reciever;

  @Column(name = "amount")
  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private TransferStatus transferStatus;

  @Column(name = "created_at")
  private Instant createdAt;
}
