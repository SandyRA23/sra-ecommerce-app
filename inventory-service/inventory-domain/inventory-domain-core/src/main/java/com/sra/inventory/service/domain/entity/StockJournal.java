package com.sra.inventory.service.domain.entity;

import com.sra.domain.entity.BaseEntity;
import com.sra.domain.valueobject.InventoryId;
import com.sra.inventory.service.domain.valueobject.StockJournalId;

import java.util.UUID;

public class StockJournal extends BaseEntity<StockJournalId> {
    private InventoryId inventoryId;
    private UUID productId;
    private UUID sourceWarehouseId;
    private UUID destinationWarehouseId;
    private int quantity;
    private String transactionType;
    private String transactionDate;


    public StockJournal(UUID productId, UUID sourceWarehouseId, UUID destinationWarehouseId, int quantity, String transactionType) {
        this.productId = productId;
        this.sourceWarehouseId = sourceWarehouseId;
        this.destinationWarehouseId = destinationWarehouseId;
        this.quantity = quantity;
        this.transactionType = transactionType;
        this.transactionDate = java.time.LocalDate.now().toString();
    }


    void initializeStockJournal(InventoryId inventoryId, StockJournalId stockJournalId) {
        this.inventoryId = inventoryId;
        super.setId(stockJournalId);
    }

}
