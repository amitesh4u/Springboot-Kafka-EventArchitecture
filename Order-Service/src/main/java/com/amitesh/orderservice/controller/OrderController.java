package com.amitesh.orderservice.controller;

import com.amitesh.OrderStatus;
import com.amitesh.dto.Order;
import com.amitesh.dto.OrderEvent;
import com.amitesh.orderservice.kafka.OrderProducer;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
  private final OrderProducer orderProducer;

  public OrderController(OrderProducer orderProducer) {
    this.orderProducer = orderProducer;
  }

  @PostMapping("/orders")
  public ResponseEntity<String> produce(@RequestParam("name") String orderName,
      @RequestParam("qty") Integer quantity, @RequestParam("price") Double price) {

    Order order = new Order(UUID.randomUUID().toString(), orderName, quantity, price);
    LOGGER.info("Order: " + order);

    orderProducer.sendMessage(
        new OrderEvent(OrderStatus.PENDING.getStatus(), "Order is in Pending state.",
            order));
    return ResponseEntity.ok("Order Received");
  }
}
