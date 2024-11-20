package com.sra.inventory.service.dataaccess.inventory.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventories")
@Entity
public class InventoryEntity {
    @Id
    private UUID id;
    private UUID userId;
    private UUID productId;
    private UUID warehouseId;
    private String failureMessages;

    @OneToOne(mappedBy = "inventory", cascade = CascadeType.ALL)
    private InventoryAddressEntity address;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<InventoryItemEntity> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryEntity that = (InventoryEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}