package com.amitesh.emailservice.kafka;

import com.amitesh.dto.OrderEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

  @KafkaListener(id = "${kafka.consumer.email.group-id}", topics = "${order.event.topic}")
  public void consumeOrderWithConsumerRecord(final ConsumerRecord<String, OrderEvent> record, final OrderEvent orderEvent) {
    /* Here orderEvent is same as record.value(). Fetching orderEvent separately for clarity */
    LOGGER.info("Consumer Record Message {} received from Topic {} | Partition {} | Offset {} at {}",
        orderEvent, record.topic(), record.partition(), record.offset(), record.timestamp());

    /* Add logic to send Order Email */
  }

}
