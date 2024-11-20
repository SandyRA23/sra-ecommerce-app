package com.sra.inventory.service.domain.ports.output.repository;

import com.sra.domain.valueobject.InventoryId;
import com.sra.domain.valueobject.ProductId;
import com.sra.inventory.service.domain.entity.Inventory;

import java.util.Optional;

public interface InventoryRepository {
    Inventory save(Inventory inventory);

    Optional<Inventory> findByProductId(ProductId productId);

}