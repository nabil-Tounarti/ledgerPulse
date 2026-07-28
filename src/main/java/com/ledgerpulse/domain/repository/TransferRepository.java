package com.ledgerpulse.domain.repository;

import java.util.Optional;

import com.ledgerpulse.domain.model.Transfer;
import com.ledgerpulse.domain.model.TransferId;

public interface TransferRepository {
  Optional<TransferRepository> findById(TransferId transferId);

  void save(Transfer Transfer);
}
