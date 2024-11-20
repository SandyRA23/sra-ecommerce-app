package com.sra.inventory.service.domain.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateInventoryResponse {
    @NotNull
    private final UUID productId;
    @NotNull
    private final UUID warehouseId;
    @NotNull
    private final Integer quantity;
    @NotNull
    private final String message;
}
