package com.ticket.ticketapi.mapper;

import java.util.List;

import com.ticket.ticketapi.domain.Ticket;
import com.ticket.ticketapi.domain.dto.TicketDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {

  TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

  TicketDTO toDTO(Ticket entity);

  Ticket toEntity(TicketDTO dto);

  List<Ticket> toEntityList(List<TicketDTO> listDTO);
  List<TicketDTO> toDtoList(List<Ticket> listEntity);
}
