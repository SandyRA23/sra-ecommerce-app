package com.sra.inventory.service.domain.rest;

import com.sra.inventory.service.domain.dto.create.CreateInventoryCommand;
import com.sra.inventory.service.domain.dto.create.CreateInventoryResponse;
import com.sra.inventory.service.domain.ports.input.service.InventoryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/inventories", produces = "application/vnd.api.v1+json")
public class InventoryController {

    private final InventoryApplicationService inventoryApplicationService;

    public InventoryController(InventoryApplicationService inventoryApplicationService) {
        this.inventoryApplicationService = inventoryApplicationService;
    }

    @GetMapping
    public String getStock(){
        return "This is Inventory";
    }

    @PostMapping
    public ResponseEntity<CreateInventoryResponse> createInventory(@RequestBody CreateInventoryCommand createInventoryCommand) {
        log.info("Creating inventory", createInventoryCommand.getProductId());
        CreateInventoryResponse createInventoryResponse = inventoryApplicationService.createInventory(createInventoryCommand);
        log.info("Inventory created with product id: {}", createInventoryResponse.getProductId());
        return ResponseEntity.ok(createInventoryResponse);
    }

}
