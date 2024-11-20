package com.sra.inventory.service.dataaccess.inventory.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(InventoryItemEntityId.class)
@Table(name = "inventory_items")
@Entity
public class InventoryItemEntity {
    @Id
    private Long id;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INVENTORY_ID")
    private InventoryEntity inventory;

    private UUID productId;
    private UUID warehouseId;
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryItemEntity that = (InventoryItemEntity) o;
        return id.equals(that.id) && inventory.equals(that.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inventory);
    }
}
