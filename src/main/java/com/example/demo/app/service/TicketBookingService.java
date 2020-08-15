package com.example.demo.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.app.dao.TicketBookingDAO;
import com.example.demo.app.entities.Ticket;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDAO tdao;
	
	public Ticket createTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return tdao.save(ticket);
	}

	
	public Optional<Ticket> findTicketByID(Integer ticketId)
	{
		return tdao.findById(ticketId);
	}


	public Iterable<Ticket> getAllBookedTickets() {
		// TODO Auto-generated method stub
		return tdao.findAll();
	}


	public void deleteTicket(Integer ticketId) {
		// TODO Auto-generated method stub
		 tdao.deleteById(ticketId);
	}


	public Ticket updateTicket(Integer ticketId, String newDestination) {
		// TODO Auto-generated method stub
		
		Optional<Ticket> ticket=tdao.findById(ticketId);
		
		ticket.get().setDestinationStation(newDestination);
		
		tdao.save(ticket.get());
		
		return ticket.get();
	}

}
