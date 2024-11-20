package com.sra.inventory.service.domain.entity;

import com.sra.domain.entity.BaseEntity;
import com.sra.inventory.service.domain.valueobject.StockTransferStatus;
import com.sra.inventory.service.domain.valueobject.StockQuantity;
import com.sra.inventory.service.domain.valueobject.StockTransferRequestId;

public class StockTransferRequest extends BaseEntity<StockTransferRequestId> {
    private final Product product;
    private final Warehouse sourceWarehouse;
    private final Warehouse destinationWarehouse;
    private final StockQuantity quantity;
    private StockTransferStatus status;
    private String requestDate;

    private StockTransferRequest(Builder builder) {
        super.setId(builder.id);
        product = builder.product;
        sourceWarehouse = builder.sourceWarehouse;
        destinationWarehouse = builder.destinationWarehouse;
        quantity = builder.quantity;
        status = builder.status;
        requestDate = builder.requestDate;
    }

    public static final class Builder {
        private StockTransferRequestId id;
        private final Product product;
        private final Warehouse sourceWarehouse;
        private final Warehouse destinationWarehouse;
        private final StockQuantity quantity;
        private StockTransferStatus status;
        private String requestDate;


        public Builder(Product product, Warehouse sourceWarehouse, Warehouse destinationWarehouse, StockQuantity quantity) {
            this.product = product;
            this.sourceWarehouse = sourceWarehouse;
            this.destinationWarehouse = destinationWarehouse;
            this.quantity = quantity;
        }

        public Builder id(StockTransferRequestId val) {
            id = val;
            return this;
        }

        public Builder status(StockTransferStatus val) {
            status = val;
            return this;
        }

        public Builder requestDate(String val) {
            requestDate = val;
            return this;
        }

        public StockTransferRequest build() {
            return new StockTransferRequest(this);
        }

        void initializeStockTransferRequest() {
            //????
        }

        /*public void approveTransfer() {
            if (status == StockTransferStatus.PENDING) {
                sourceWarehouse.decreaseStock(product.getId(), quantity.getQuantity());
                destinationWarehouse.increaseStock(product.getId(), quantity.getQuantity());
                status = StockTransferStatus.APPROVED;

                sourceWarehouse.createJournal(this, "OUT");
                destinationWarehouse.createJournal(this, "IN");
            }
        }*/


    }
}
