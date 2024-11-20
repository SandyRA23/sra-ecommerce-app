package com.sra.inventory.service.domain;

import com.sra.inventory.service.domain.dto.message.OrderResponse;
import com.sra.inventory.service.domain.ports.input.message.listener.order.OrderResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static com.sra.inventory.service.domain.entity.Inventory.FAILURE_MESSAGE_DELIMITER;


@Validated
@Service
@Slf4j
public class OrderResponseMessageListenerImpl implements OrderResponseMessageListener {
    private final InventoryOrderSaga inventoryOrderSaga;

    public OrderResponseMessageListenerImpl(InventoryOrderSaga inventoryOrderSaga) {
        this.inventoryOrderSaga = inventoryOrderSaga;
    }

    @Override
    public void orderCompleted(OrderResponse orderResponse) {
//        InventoryPaidEvent domainEvent = inventoryOrderSaga.process(orderResponse);
//        log.info("Publishing OrderPaidEvent for order id: {}", orderResponse.getInventoryId());
//        domainEvent.fire();
    }

    @Override
    public void orderCancelled(OrderResponse orderResponse) {
//        inventoryOrderSaga.rollback(orderResponse);
//        log.info("Inventory is roll backed for inventory id: {} with failure messages: {}",
//                orderResponse.getInventoryId(),
//                String.join(FAILURE_MESSAGE_DELIMITER, orderResponse.getFailureMessage()));
    }
}
