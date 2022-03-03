package com.ticket.ticketapi.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("ticket")
@Data
public class Ticket {

  @Id
  private String id;
  private Integer winningNumber;
  private String status;

  public Ticket(){}

  public Ticket (Integer winningNumber, String status) {
    this.winningNumber = winningNumber;
    this.status = status;
  }

  public Ticket(String id, Integer winningNumber, String status) {
    this.id = id;
    this.winningNumber = winningNumber;
    this.status = status;
  }
}
