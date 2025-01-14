package com.amitesh.orderservice.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  @Value(value = "${order.event.topic}")
  private String topic;

  @Bean
  public NewTopic messageTopic() {
    return TopicBuilder.name(topic)
        .partitions(4)
        .replicas(1)
        .build();
  }
}
