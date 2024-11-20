package com.sra.inventory.service.dataaccess.inventory.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemEntityId implements Serializable {

    private Long id;
    private InventoryEntity inventory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryItemEntityId that = (InventoryItemEntityId) o;
        return id.equals(that.id) && inventory.equals(that.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inventory);
    }
}
