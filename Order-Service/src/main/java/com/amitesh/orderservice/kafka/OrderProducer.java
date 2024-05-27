package com.amitesh.orderservice.kafka;

import com.amitesh.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

  @Value(value ="${order.event.topic}")
  private String topic;

  private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

  public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(final OrderEvent orderEvent) {
    LOGGER.info("OrderEvent {} sent to Topic {}", orderEvent, topic);
    kafkaTemplate.send(topic, orderEvent);
  }
}
