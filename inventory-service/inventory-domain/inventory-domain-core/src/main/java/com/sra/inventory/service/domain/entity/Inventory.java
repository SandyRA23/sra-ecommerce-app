package com.sra.inventory.service.domain.entity;

import com.sra.domain.entity.AggregateRoot;
import com.sra.domain.valueobject.*;
import com.sra.inventory.service.domain.valueobject.StockQuantity;
import com.sra.inventory.service.domain.valueobject.StockStatus;


import java.util.List;
import java.util.UUID;

public class Inventory extends AggregateRoot<InventoryId> {
    private final UserId userId;
    private final ProductId productId;
    private final WarehouseId warehouseId;
    private StockQuantity quantity;
    private StockStatus stockStatus;
    private String lastUpdated;
    private List<String> failureMessages;
    public static final String FAILURE_MESSAGE_DELIMITER = ",";


    private Inventory(Builder builder) {
        super.setId(builder.inventoryId);
        userId = builder.userId;
        productId = builder.productId;
        warehouseId = builder.warehouseId;
        quantity = builder.quantity;
        stockStatus = builder.stockStatus;
        lastUpdated = builder.lastUpdated;
        failureMessages = builder.failureMessages;
    }

    public static Builder builder() {
        return new Builder();
    }

    public UserId getUserId() {
        return userId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public WarehouseId getWarehouseId() {
        return warehouseId;
    }

    public StockQuantity getQuantity() {
        return quantity;
    }

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    public static final class Builder {
        private InventoryId inventoryId;
        private UserId userId;
        private ProductId productId;
        private WarehouseId warehouseId;
        private StockQuantity quantity;
        private StockStatus stockStatus;
        private String lastUpdated;
        private List<String> failureMessages;

        public Builder() {
        }

        public Builder inventoryId(InventoryId val) {
            inventoryId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder stockQuantity(StockQuantity val) {
            quantity = val;
            return this;
        }

        public Builder lastUpdated(String val) {
            lastUpdated = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public Inventory build() {
            return new Inventory(this);
        }

        public Builder productId(ProductId val) {
            productId = val;
            return this;
        }

        public Builder warehouseId(WarehouseId val) {
            warehouseId = val;
            return this;
        }

        public Builder stockStatus(StockStatus val) {
            stockStatus = val;
            return this;
        }

    }

    public void initializeInventory() {
        setId(new InventoryId(UUID.randomUUID()));
        stockStatus = StockStatus.IN_STOCK;
        //initializeStockJournal();
        //initializeStockTransferRequest();
    }

}
