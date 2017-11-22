package com.junit.spring.service.dao;

import org.springframework.stereotype.Component;

import com.junit.spring.service.dto.Ticket;

@Component
public class TicketDAOImpl implements TicketDAO {

	public int createTicket(Ticket ticket) {
		return 1;
	}

}
