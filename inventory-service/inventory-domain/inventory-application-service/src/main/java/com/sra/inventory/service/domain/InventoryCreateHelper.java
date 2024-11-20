package com.sra.inventory.service.domain;

import com.sra.inventory.service.domain.dto.create.CreateInventoryCommand;
import com.sra.inventory.service.domain.entity.Inventory;
import com.sra.inventory.service.domain.entity.User;
import com.sra.inventory.service.domain.event.InventoryCreatedEvent;
import com.sra.inventory.service.domain.exception.InventoryDomainException;
import com.sra.inventory.service.domain.mapper.InventoryDataMapper;
import com.sra.inventory.service.domain.ports.output.message.publisher.order.InventoryCreatedOrderRequestMessagePublisher;
import com.sra.inventory.service.domain.ports.output.repository.InventoryRepository;
import com.sra.inventory.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
public class InventoryCreateHelper {
    private final InventoryDomainService inventoryDomainService;

    private final InventoryRepository inventoryRepository;

    private final UserRepository userRepository;

    private final InventoryDataMapper inventoryDataMapper;

    private final InventoryCreatedOrderRequestMessagePublisher inventoryCreatedEventDomainEventPublisher;

    public InventoryCreateHelper(InventoryDomainService inventoryDomainService,
                                 InventoryRepository inventoryRepository,
                                 UserRepository userRepository,
                                 InventoryDataMapper inventoryDataMapper,
                                 InventoryCreatedOrderRequestMessagePublisher inventoryCreatedEventDomainEventPublisher) {
        this.inventoryDomainService = inventoryDomainService;
        this.inventoryRepository = inventoryRepository;
        this.userRepository = userRepository;
        this.inventoryDataMapper = inventoryDataMapper;
        this.inventoryCreatedEventDomainEventPublisher = inventoryCreatedEventDomainEventPublisher;
    }

    @Transactional
    public InventoryCreatedEvent persistInventory(CreateInventoryCommand createInventoryCommand) {
        checkUser(createInventoryCommand.getUserId());
        Inventory inventory = inventoryDataMapper.createInventoryCommandToInventory(createInventoryCommand);
        InventoryCreatedEvent inventoryCreatedEvent = inventoryDomainService.validateAndInitiateInventory(inventory,
        inventoryCreatedEventDomainEventPublisher);
        saveInventory(inventory);
        log.info("Inventory is created with id: {}", inventoryCreatedEvent.getInventory().getId().getValue());
        return inventoryCreatedEvent;
    }

//    private Seller checkSeller(CreateOrderCommand createOrderCommand) {
//        Seller seller = orderDataMapper.createOrderCommandToSeller(createOrderCommand);
//        Optional<Seller> optionalSeller = sellerRepository.findSellerInformation(seller);
//        if (optionalSeller.isEmpty()) {
//            log.warn("Could not find seller with seller id: {}", createOrderCommand.getSellerId());
//            throw new OrderDomainException("Could not find seller with seller id: " +
//                    createOrderCommand.getSellerId());
//        }
//        return optionalSeller.get();
//    }

    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("Could not find customer with user id: {}", userId);
            throw new InventoryDomainException("Could not find customer with user id: " + user);
        }
    }

    private Inventory saveInventory(Inventory inventory) {
        Inventory inventoryResult = inventoryRepository.save(inventory);
        if (inventoryResult == null) {
            log.error("Could not save inventory!");
            throw new InventoryDomainException("Could not save inventory!");
        }
        log.info("Inventory is saved with id: {}", inventoryResult.getId().getValue());
        return inventoryResult;
    }
}
