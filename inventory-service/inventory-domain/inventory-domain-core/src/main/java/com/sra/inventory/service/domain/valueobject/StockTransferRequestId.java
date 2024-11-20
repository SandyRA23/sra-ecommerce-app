package com.sra.inventory.service.domain.valueobject;

import com.sra.domain.valueobject.BaseId;

public class StockTransferRequestId extends BaseId<Long> {
    public StockTransferRequestId(Long value) {
        super(value);
    }
}
