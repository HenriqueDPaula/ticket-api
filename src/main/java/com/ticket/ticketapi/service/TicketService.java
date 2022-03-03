package com.ticket.ticketapi.service;

import java.util.List;
import java.util.Optional;

import com.ticket.ticketapi.domain.dto.TicketDTO;
import com.ticket.ticketapi.mapper.TicketMapper;
import com.ticket.ticketapi.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

  @Autowired
  private TicketRepository ticketRepository;

  private final TicketMapper MAPPER = TicketMapper.INSTANCE;

  public Optional<List<TicketDTO>> findByWinningNumber(Integer winningNumber) {
    return Optional.ofNullable(MAPPER.toDtoList(ticketRepository.findByWinningNumber(winningNumber)));
  }

  public Optional<List<TicketDTO>> findAll() {
    return Optional.ofNullable(MAPPER.toDtoList(ticketRepository.findAll()));
  }

  public Optional<TicketDTO> saveTicket(TicketDTO ticketDTO) {
    return Optional.of(MAPPER.toDTO(ticketRepository.save(TicketMapper.INSTANCE.toEntity(ticketDTO))));
  }
}
