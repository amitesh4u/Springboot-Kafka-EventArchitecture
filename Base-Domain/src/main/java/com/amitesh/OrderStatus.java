package com.amitesh;

import lombok.Getter;

@Getter
public enum OrderStatus {

  PENDING("Pending"),
  INPROGRESS("In Progress"),
  COMPLETED("Completed");

  private final String status;
  OrderStatus(String status) {
    this.status = status;
  }

}
