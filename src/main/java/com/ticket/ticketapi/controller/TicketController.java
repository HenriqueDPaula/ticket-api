package com.ticket.ticketapi.controller;

import javax.validation.Valid;

import com.ticket.ticketapi.domain.dto.TicketDTO;
import com.ticket.ticketapi.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

  @Autowired
  private TicketService ticketService;

  @GetMapping("/{winningNumber}")
  public ResponseEntity findByWinningNumber(@PathVariable Integer winningNumber) {
    return ticketService.findByWinningNumber(winningNumber)
        .map(ticket -> ResponseEntity.ok().body(ticket))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping()
  public ResponseEntity insertTicket(@RequestBody @Valid TicketDTO ticketDTO) {
    return ticketService.saveTicket(ticketDTO)
        .map(ticket -> ResponseEntity.ok(ticket))
        .orElse(ResponseEntity.noContent().build());
  }

  @GetMapping()
  public ResponseEntity findByAll() {
    return ticketService.findAll()
        .map(listResponse -> ResponseEntity.ok(listResponse))
        .orElse(ResponseEntity.notFound().build());
  }

}
