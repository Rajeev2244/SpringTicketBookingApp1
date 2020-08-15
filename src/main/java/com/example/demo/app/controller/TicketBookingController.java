package com.example.demo.app.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.app.entities.Ticket;
import com.example.demo.app.service.TicketBookingService;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;
	
	@PostMapping(value = "/createTicket")
	public Ticket createTicket(@RequestBody Ticket ticket)
	{
		return ticketBookingService.createTicket(ticket);
	}
	
	@GetMapping(value = "/ticket/{ticketId}")
	public Optional<Ticket> findTicketByID(@PathVariable("ticketId") Integer ticketId)
	{
		return ticketBookingService.findTicketByID(ticketId);
	}
	
	
	@GetMapping("/allTickets")
	public Iterable<Ticket> getAllBookedTickets()
	{
		return ticketBookingService.getAllBookedTickets();
	}

	@DeleteMapping(value = "/deleteTicket/{ticketID}")
	public void deleteTicket(@PathVariable("ticketID") Integer ticketId)
	{
		ticketBookingService.deleteTicket(ticketId);
	}
	
	
	@PutMapping(value = "/updateTicket/{ticketId}/{newDestination}")
	public Ticket updateTicket(@PathVariable Map<String,String> pathVars)
	{
		Integer ticketId=Integer.parseInt(pathVars.get("ticketId"));
		String newDestination=pathVars.get("newDestination");
		return ticketBookingService.updateTicket(ticketId,newDestination);
	}
	
}
