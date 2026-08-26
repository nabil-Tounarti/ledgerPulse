package com.ledgerpulse.domain.ports.out;

import com.ledgerpulse.domain.model.TransferId;

public interface NotificationPort {
  void publish(TransferId id);
}
