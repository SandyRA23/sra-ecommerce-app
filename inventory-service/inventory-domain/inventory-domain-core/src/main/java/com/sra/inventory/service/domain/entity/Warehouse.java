package com.sra.inventory.service.domain.entity;

import com.sra.domain.entity.AggregateRoot;
import com.sra.domain.valueobject.WarehouseId;
import com.sra.domain.valueobject.Address;
import lombok.Getter;

import java.util.*;

@Getter
public class Warehouse extends AggregateRoot<WarehouseId> {
    private String name;
    private Address location;
    private int maxCapacity;
    private boolean isActive;
    private Map<UUID, Inventory> inventory = new HashMap<>();
    private List<StockJournal> journalEntries = new ArrayList<>();

    public Warehouse(Warehouse builder) {
        super.setId(builder.getId());
        name = builder.name;
        location = builder.location;
        maxCapacity = builder.maxCapacity;
        isActive = builder.isActive;
        inventory = builder.inventory;
        journalEntries = builder.journalEntries;
    }

    public List<Inventory> getInventoryItems() {
        return new ArrayList<>(inventory.values());
    }

    public boolean checkInventory(UUID productId, int requiredQuantity) {
        Inventory item = inventory.get(productId);
        if (item == null) {
            return false;
        }
        return item.getQuantity().getQuantity() >= requiredQuantity;
    }

    public void addProduct(Product product, int initialStock, String unit) {
        UUID productId = product.getId().getValue();
        Inventory item = inventory.get(productId);

        if (item != null) {
            int newQuantity = item.getQuantity().getQuantity() + initialStock;
            item.getQuantity().setQuantity(newQuantity);
        }

        //createJournalForAddProduct(productId, initialStock, unit);
    }

    /*public void createJournalForAddProduct(UUID productId, int quantity, String unit) {
        journalEntries.add(new StockJournal(productId, quantity, unit, "ADD"));
    }*/



    public static class Builder {
        private WarehouseId id;
        private String name;
        private Address location;
        private int maxCapacity;
        private boolean isActive;
        private Map<UUID, Inventory> inventory = new HashMap<>();
        private List<StockJournal> journalEntries = new ArrayList<>();

        public Builder() {
        }

        public Builder id(WarehouseId val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder location(Address val) {
            location = val;
            return this;
        }

        public Builder maxCapacity(int val) {
            maxCapacity = val;
            return this;
        }

        public Builder isActive(boolean val) {
            isActive = val;
            return this;
        }

        public Builder inventory(Map<UUID, Inventory> val) {
            inventory = val;
            return this;
        }

        public Builder journalEntries(List<StockJournal> val) {
            journalEntries = val;
            return this;
        }

        public Warehouse build() {
            return new Warehouse(this.build());
        }

    }
}
