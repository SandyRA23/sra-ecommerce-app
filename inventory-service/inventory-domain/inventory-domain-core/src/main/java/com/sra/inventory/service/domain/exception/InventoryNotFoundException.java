package com.sra.inventory.service.domain.exception;

public class InventoryNotFoundException extends RuntimeException {
    public InventoryNotFoundException(String message) {
        super(message);
    }
    public InventoryNotFoundException(String message, Throwable cause) { super(message, cause); }
}
