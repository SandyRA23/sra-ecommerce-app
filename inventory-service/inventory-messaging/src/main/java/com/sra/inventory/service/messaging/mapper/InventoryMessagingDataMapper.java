package com.sra.inventory.service.messaging.mapper;

import com.sra.kafka.inventory.avro.model.*;
import com.sra.inventory.service.domain.dto.message.OrderResponse;
import com.sra.inventory.service.domain.entity.Inventory;
import com.sra.inventory.service.domain.event.InventoryCreatedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class InventoryMessagingDataMapper {
    public OrderRequestAvroModel inventoryCreatedEventToOrderRequestAvroModel(InventoryCreatedEvent inventoryCreatedEvent) {
        Inventory inventory = inventoryCreatedEvent.getInventory();
        return OrderRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setUserId(inventory.getUserId().getValue().toString())
                .setProductId(inventory.getId().getValue().toString())
                .setWarehouseId(inventory.getId().getValue().toString())
                .setQuantity(inventory.getQuantity().getValue().toString())
                .setCreatedAt(inventoryCreatedEvent.getCreatedAt().toInstant())
                .build();
    }

//    public PaymentRequestAvroModel orderCancelledEventToPaymentRequestAvroModel(OrderCancelledEvent orderCancelledEvent) {
//        Order order = orderCancelledEvent.getOrder();
//        return PaymentRequestAvroModel.newBuilder()
//                .setId(UUID.randomUUID().toString())
//                .setSagaId("")
//                .setCustomerId(order.getCustomerId().getValue().toString())
//                .setOrderId(order.getId().getValue().toString())
//                .setPrice(order.getPrice().getAmount())
//                .setCreatedAt(orderCancelledEvent.getCreatedAt().toInstant())
//                .setPaymentOrderStatus(PaymentOrderStatus.CANCELLED)
//                .build();
//    }

    public OrderResponse orderResponseAvroModelToOrderResponse(OrderResponseAvroModel
                                                                       orderResponseAvroModel) {
        return OrderResponse.builder()
                .id(orderResponseAvroModel.getId())
                .sagaId(orderResponseAvroModel.getSagaId())
                .orderId(orderResponseAvroModel.getOrderId())
                .inventoryId(orderResponseAvroModel.getInventoryId())
                .userId(orderResponseAvroModel.getUserId())
                .productId(orderResponseAvroModel.getProductId())
                .warehouseId(orderResponseAvroModel.getWarehouseId())
                .quantity(orderResponseAvroModel.getQuantity())
                .createdAt(orderResponseAvroModel.getCreatedAt())
                .failureMessage(orderResponseAvroModel.getFailureMessages())
                .build();
    }

}
