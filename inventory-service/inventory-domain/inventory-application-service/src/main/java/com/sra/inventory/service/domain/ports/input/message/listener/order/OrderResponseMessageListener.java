package com.sra.inventory.service.domain.ports.input.message.listener.order;

import com.sra.inventory.service.domain.dto.message.OrderResponse;

public interface OrderResponseMessageListener {
    void orderCompleted(OrderResponse orderResponse);

    void orderCancelled(OrderResponse orderResponse);
}
