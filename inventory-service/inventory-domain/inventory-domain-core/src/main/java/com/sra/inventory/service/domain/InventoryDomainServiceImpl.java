package com.sra.inventory.service.domain;

import com.sra.domain.event.publisher.DomainEventPublisher;
import com.sra.inventory.service.domain.entity.Inventory;
import com.sra.inventory.service.domain.entity.Product;
import com.sra.inventory.service.domain.entity.Warehouse;
import com.sra.inventory.service.domain.event.InventoryCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static com.sra.domain.DomainConstants.UTC;

@Slf4j
public class InventoryDomainServiceImpl implements InventoryDomainService {
    @Override
    public void addProductToWarehouse(Warehouse warehouse, Product product, int initialStock, String unit) {
        warehouse.addProduct(product, initialStock, unit);
    }

    @Override
    public InventoryCreatedEvent validateAndInitiateInventory(Inventory inventory,
                                                              DomainEventPublisher<InventoryCreatedEvent>
                                                                      inventoryCreatedEventDomainEventPublisher) {
        //inventory.validateInventory();
        inventory.initializeInventory();
        log.info("Inventory with id: {} is initiated", inventory.getId().getValue());
        return new InventoryCreatedEvent(inventory, ZonedDateTime.now(ZoneId.of(UTC)), inventoryCreatedEventDomainEventPublisher);
    }

    @Override
    public boolean checkInventoryInWarehouse(Warehouse warehouse, UUID productId, int requiredQuantity) {
        return warehouse.checkInventory(productId, requiredQuantity);
    }

    @Override
    public boolean checkInventoryAcrossWarehouses(List<Warehouse> warehouses, Product product, int requiredQuantity) {
        int totalStock = 0;
        for (Warehouse warehouse : warehouses) {
            Inventory item = warehouse.getInventoryItems().stream()
                    .filter(inventoryItem -> inventoryItem.getProductId().equals(product.getId()))
                    .findFirst()
                    .orElse(null);

            if (item != null) {
                totalStock += item.getQuantity().getQuantity();
            }
            if (totalStock >= requiredQuantity) {
                return true;
            }
        }
        return false;
    }

}


