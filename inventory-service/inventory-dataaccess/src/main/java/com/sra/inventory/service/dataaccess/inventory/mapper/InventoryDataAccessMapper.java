package com.sra.inventory.service.dataaccess.inventory.mapper;

import com.sra.inventory.service.dataaccess.inventory.entity.InventoryEntity;
import com.sra.inventory.service.domain.entity.Inventory;
import com.sra.domain.valueobject.*;
import com.sra.inventory.service.domain.entity.Product;
import com.sra.inventory.service.domain.entity.Warehouse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.sra.inventory.service.domain.entity.Inventory.FAILURE_MESSAGE_DELIMITER;

@Component
public class InventoryDataAccessMapper {

    public InventoryEntity inventoryToInventoryEntity(Inventory inventory) {
        InventoryEntity inventoryEntity = InventoryEntity.builder()
                .id(inventory.getId().getValue())
                .userId(inventory.getUserId().getValue())
                .productId(inventory.getProductId().getValue())
                .warehouseId(inventory.getWarehouseId().getValue())
                .failureMessages(inventory.getFailureMessages() != null ?
                        String.join(FAILURE_MESSAGE_DELIMITER, inventory.getFailureMessages()) : "")
                .build();

        return inventoryEntity;
    }

    public Inventory inventoryEntityToInventory(InventoryEntity inventoryEntity) {
        return Inventory.builder()
                .inventoryId(new InventoryId(inventoryEntity.getId()))
                .userId(new UserId(inventoryEntity.getUserId()))
                .productId(new ProductId(inventoryEntity.getProductId()))
                .warehouseId(new WarehouseId(inventoryEntity.getWarehouseId()))
                .failureMessages(inventoryEntity.getFailureMessages().isEmpty() ? new ArrayList<>() :
                        new ArrayList<>(Arrays.asList(inventoryEntity.getFailureMessages()
                                .split(FAILURE_MESSAGE_DELIMITER))))
                .build();
    }

    /*private List<OrderItem> orderItemEntitiesToOrderItems(List<OrderItemEntity> items) {
        return items.stream()
                .map(orderItemEntity -> OrderItem.builder()
                        .orderItemId(new OrderItemId(orderItemEntity.getId()))
                        .product(new Product(new ProductId(orderItemEntity.getProductId())))
                        .price(new Money(orderItemEntity.getPrice()))
                        .quantity(orderItemEntity.getQuantity())
                        .subTotal(new Money(orderItemEntity.getSubTotal()))
                        .build())
                .collect(Collectors.toList());
    }

    private StreetAddress addressEntityToDeliveryAddress(OrderAddressEntity address) {
        return new StreetAddress(address.getId(),
                address.getStreet(),
                address.getPostalCode(),
                address.getCity());
    }

    private List<OrderItemEntity> orderItemsToOrderItemEntities(List<OrderItem> items) {
        return items.stream()
                .map(orderItem -> OrderItemEntity.builder()
                        .id(orderItem.getId().getValue())
                        .productId(orderItem.getProduct().getId().getValue())
                        .price(orderItem.getPrice().getAmount())
                        .quantity(orderItem.getQuantity())
                        .subTotal(orderItem.getSubTotal().getAmount())
                        .build())
                .collect(Collectors.toList());
    }

    private OrderAddressEntity deliveryAddressToAddressEntity(StreetAddress deliveryAddress) {
        return OrderAddressEntity.builder()
                .id(deliveryAddress.getId())
                .street(deliveryAddress.getStreet())
                .postalCode(deliveryAddress.getPostalCode())
                .city(deliveryAddress.getCity())
                .build();
    }*/

}
