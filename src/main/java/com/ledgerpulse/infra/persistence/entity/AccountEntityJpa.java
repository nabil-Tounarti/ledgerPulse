package com.ledgerpulse.infra.persistence.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AccountEntityJpa {
  @Id
  @Column(name = "id")
  private UUID id;

  @Column(name = "username", nullable = false, unique = true)
  private String userName;

  @Column(name = "balance", nullable = false, precision = 19, scale = 2)
  private BigDecimal balance;

  @Column(name = "currency", nullable = false)
  private String currency;

  @Version
  private Long version;
}
