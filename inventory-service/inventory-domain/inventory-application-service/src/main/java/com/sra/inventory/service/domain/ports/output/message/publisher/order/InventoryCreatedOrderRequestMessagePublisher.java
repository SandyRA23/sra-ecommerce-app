package com.sra.inventory.service.domain.ports.output.message.publisher.order;

import com.sra.domain.event.publisher.DomainEventPublisher;
import com.sra.inventory.service.domain.event.InventoryCreatedEvent;

public interface InventoryCreatedOrderRequestMessagePublisher extends DomainEventPublisher<InventoryCreatedEvent> {
}
