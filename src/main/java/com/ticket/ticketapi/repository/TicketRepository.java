package com.ticket.ticketapi.repository;

import java.util.List;

import com.ticket.ticketapi.domain.Ticket;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

  @Query(" { 'winningNumber': ?0 }")
  List<Ticket> findByWinningNumber(Integer winningNumber);
}
