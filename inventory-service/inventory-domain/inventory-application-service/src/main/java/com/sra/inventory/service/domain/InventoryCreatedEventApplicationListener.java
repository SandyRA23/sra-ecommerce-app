package com.sra.inventory.service.domain;

import com.sra.inventory.service.domain.event.InventoryCreatedEvent;
import com.sra.inventory.service.domain.ports.output.message.publisher.order.InventoryCreatedOrderRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class InventoryCreatedEventApplicationListener {
    private final InventoryCreatedOrderRequestMessagePublisher inventoryCreatedOrderRequestMessagePublisher;

    public InventoryCreatedEventApplicationListener(InventoryCreatedOrderRequestMessagePublisher
                                                            inventoryCreatedOrderRequestMessagePublisher) {
        this.inventoryCreatedOrderRequestMessagePublisher = inventoryCreatedOrderRequestMessagePublisher;
    }

    @TransactionalEventListener
    void process(InventoryCreatedEvent inventoryCreatedEvent) {
        inventoryCreatedOrderRequestMessagePublisher.publish(inventoryCreatedEvent);
    }
}
