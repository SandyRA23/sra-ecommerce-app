package com.sra.inventory.service.dataaccess.inventory.adapter;

import com.sra.domain.valueobject.ProductId;
import com.sra.inventory.service.dataaccess.inventory.mapper.InventoryDataAccessMapper;
import com.sra.inventory.service.dataaccess.inventory.repository.InventoryJpaRepository;
import com.sra.inventory.service.domain.entity.Inventory;
import com.sra.inventory.service.domain.ports.output.repository.InventoryRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class InventoryRepositoryImpl implements InventoryRepository {

    private final InventoryJpaRepository inventoryJpaRepository;
    private final InventoryDataAccessMapper inventoryDataAccessMapper;

    public InventoryRepositoryImpl(InventoryJpaRepository inventoryJpaRepository,
                                   InventoryDataAccessMapper inventoryDataAccessMapper) {
        this.inventoryJpaRepository = inventoryJpaRepository;
        this.inventoryDataAccessMapper = inventoryDataAccessMapper;
    }

    @Override
    public Inventory save(Inventory inventory){
        return inventoryDataAccessMapper.inventoryEntityToInventory(inventoryJpaRepository.save(inventoryDataAccessMapper.inventoryToInventoryEntity(inventory)));
    }

    @Override
    public Optional<Inventory> findByProductId(ProductId productId) {
        return inventoryJpaRepository.findByProductId(productId.getValue()).map(inventoryDataAccessMapper::inventoryEntityToInventory);
    }

}