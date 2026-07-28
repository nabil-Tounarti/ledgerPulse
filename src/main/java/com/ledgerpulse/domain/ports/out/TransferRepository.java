package com.ledgerpulse.domain.ports.out;

import java.util.Optional;
import com.ledgerpulse.domain.model.Transfer;
import com.ledgerpulse.domain.model.TransferId;

public interface TransferRepository {
  Optional<Transfer> findById(TransferId id);

  void save(Transfer transfer);
}
