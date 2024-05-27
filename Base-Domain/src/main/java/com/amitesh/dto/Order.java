package com.amitesh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  private String orderId;
  private String orderName;
  private Integer quantity;
  private Double price;

}
