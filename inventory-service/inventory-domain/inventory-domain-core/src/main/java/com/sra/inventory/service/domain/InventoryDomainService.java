package com.sra.inventory.service.domain;

import com.sra.domain.event.publisher.DomainEventPublisher;
import com.sra.inventory.service.domain.entity.Inventory;
import com.sra.inventory.service.domain.entity.Product;
import com.sra.inventory.service.domain.entity.Warehouse;
import com.sra.inventory.service.domain.event.InventoryCreatedEvent;


import java.util.List;
import java.util.UUID;

public interface InventoryDomainService {
    void addProductToWarehouse(Warehouse warehouse, Product product, int initialStock, String unit);

    InventoryCreatedEvent validateAndInitiateInventory(Inventory inventory,
                                                       DomainEventPublisher<InventoryCreatedEvent>
                                                               inventoryCreatedEventDomainEventPublisher);

    boolean checkInventoryInWarehouse(Warehouse warehouse, UUID productId, int requiredQuantity);
    boolean checkInventoryAcrossWarehouses(List<Warehouse> warehouses, Product product, int requiredQuantity);
}
