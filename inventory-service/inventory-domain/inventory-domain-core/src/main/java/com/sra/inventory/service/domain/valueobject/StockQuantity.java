package com.sra.inventory.service.domain.valueobject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockQuantity {
    private int quantity;
    private String unit;

    public StockQuantity(int quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }
}
