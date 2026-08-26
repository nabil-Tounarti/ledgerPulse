package com.ledgerpulse.domain.ports.out;

import java.util.List;
import com.ledgerpulse.domain.events.DomainEvent;

public interface EventPublisher {
  void publish(List<DomainEvent> events);
}
