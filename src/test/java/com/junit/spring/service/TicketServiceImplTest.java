package com.junit.spring.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junit.spring.service.dao.TicketDAO;
import com.junit.spring.service.dto.Ticket;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TicketServiceImplTest {

	private static final int RESULT = 1;
	private static final String PHONE = "123456789";
	private static final String PASSENGER_NAME = "Raghav";
	
	@Mock
	TicketDAO dao;
	
	
	
	@Autowired
	@InjectMocks //Inject the mocked out dao into setdao method in TicketServiceImpl class
	private TicketServiceImpl service;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void buyTicketsShouldReturnsAValidValue() {
	//	service = new TicketServiceImpl();
		when(dao.createTicket(any(Ticket.class))).thenReturn(1);
		int result = service.buyTicket(PASSENGER_NAME, PHONE);
		assertEquals(result, RESULT);
	}

}
