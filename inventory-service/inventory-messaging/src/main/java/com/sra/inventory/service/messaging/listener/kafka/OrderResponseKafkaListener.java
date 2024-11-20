package com.sra.inventory.service.messaging.listener.kafka;

import com.sra.kafka.consumer.KafkaConsumer;
import com.sra.inventory.service.domain.ports.input.message.listener.order.OrderResponseMessageListener;
import com.sra.inventory.service.messaging.mapper.InventoryMessagingDataMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class OrderResponseKafkaListener implements KafkaConsumer<OrderResponseAvroModel> {

    private final OrderResponseMessageListener orderResponseMessageListener;
    private final InventoryMessagingDataMapper inventoryMessagingDataMapper;

    public OrderResponseKafkaListener(OrderResponseMessageListener orderResponseMessageListener,
                                      InventoryMessagingDataMapper inventoryMessagingDataMapper) {
        this.orderResponseMessageListener = orderResponseMessageListener;
        this.inventoryMessagingDataMapper = inventoryMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.order-consumer-group-id}", topics = "${inventory-service.order-response-topic-name}")
    public void receive(@Payload List<OrderResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of order responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(orderResponseAvroModel -> {
            log.info("Processing successful");
//            if (PaymentStatus.COMPLETED == orderResponseAvroModel.getPaymentStatus()) {
//                log.info("Processing successful payment for order id: {}", paymentResponseAvroModel.getOrderId());
//                paymentResponseMessageListener.paymentCompleted(orderMessagingDataMapper
//                        .paymentResponseAvroModelToPaymentResponse(paymentResponseAvroModel));
//            } else if (PaymentStatus.CANCELLED == paymentResponseAvroModel.getPaymentStatus() ||
//                    PaymentStatus.FAILED == paymentResponseAvroModel.getPaymentStatus()) {
//                log.info("Processing unsuccessful payment for order id: {}", paymentResponseAvroModel.getOrderId());
//                paymentResponseMessageListener.paymentCancelled(orderMessagingDataMapper
//                        .paymentResponseAvroModelToPaymentResponse(paymentResponseAvroModel));
//            }
        });
    }

}
