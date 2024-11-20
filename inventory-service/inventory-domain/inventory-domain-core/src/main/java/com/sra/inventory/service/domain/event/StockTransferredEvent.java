package com.sra.inventory.service.domain.event;

import com.sra.domain.event.publisher.DomainEventPublisher;
import com.sra.inventory.service.domain.entity.Inventory;

import java.time.ZonedDateTime;

public class StockTransferredEvent extends InventoryEvent{
    private final DomainEventPublisher<StockTransferredEvent> stockTransferredEventDomainEventPublisher;

    public StockTransferredEvent(Inventory inventory,
                                 ZonedDateTime createdAt,
                                 DomainEventPublisher<StockTransferredEvent> stockTransferredEventDomainEventPublisher) {
        super(inventory, createdAt);
        this.stockTransferredEventDomainEventPublisher = stockTransferredEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        stockTransferredEventDomainEventPublisher.publish(this);
    }
}
