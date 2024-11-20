package com.sra.inventory.service.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor

public class OrderResponse {
    private final String id;

    private final String sagaId;

    private final String orderId;

    private final String userId;

    private final String paymentId;

    private final String warehouseId;

    private final Integer quantity;

    private final Instant createdAt;

    private final List<String> failureMessage;
}
