package com.sra.inventory.service.domain.event;

import com.sra.domain.event.publisher.DomainEventPublisher;
import com.sra.inventory.service.domain.entity.Inventory;

import java.time.ZonedDateTime;

public class InventoryCreatedEvent extends InventoryEvent{
    private final DomainEventPublisher<InventoryCreatedEvent> inventoryCreatedEventDomainEventPublisher;

    public InventoryCreatedEvent(Inventory inventory,
                                 ZonedDateTime createdAt,
                                 DomainEventPublisher<InventoryCreatedEvent> inventoryCreatedEventDomainEventPublisher) {
        super(inventory, createdAt);
        this.inventoryCreatedEventDomainEventPublisher = inventoryCreatedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        inventoryCreatedEventDomainEventPublisher.publish(this);
    }
}
