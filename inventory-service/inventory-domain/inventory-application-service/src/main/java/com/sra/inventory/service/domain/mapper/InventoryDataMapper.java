package com.sra.inventory.service.domain.mapper;


import com.sra.domain.valueobject.ProductId;
import com.sra.domain.valueobject.UserId;
import com.sra.domain.valueobject.WarehouseId;
import com.sra.inventory.service.domain.dto.create.CreateInventoryCommand;
import com.sra.inventory.service.domain.dto.create.CreateInventoryResponse;
import com.sra.inventory.service.domain.entity.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryDataMapper {

    public CreateInventoryResponse inventoryToCreateInventoryResponse(Inventory inventory, String message) {
        return CreateInventoryResponse.builder()
//                .inventoryProductId(inventory.getProductId())
//                .inventoryQuantity(inventory.getQuantity())
                .message(message)
                .build();
    }

    public Inventory createInventoryCommandToInventory(CreateInventoryCommand createInventoryCommand) {
        return Inventory.builder()
                .userId(new UserId(createInventoryCommand.getUserId()))
                .productId(new ProductId(createInventoryCommand.getProductId()))
                .warehouseId(new WarehouseId(createInventoryCommand.getWarehouseId()))
                .build();
    }

}
