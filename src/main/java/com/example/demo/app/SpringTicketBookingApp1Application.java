package com.example.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.app.entities.Ticket;
import com.example.demo.app.service.TicketBookingService;

@SpringBootApplication
public class SpringTicketBookingApp1Application implements CommandLineRunner {

	@Autowired
	TicketBookingService ticketBookingService;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext cac=SpringApplication.run(SpringTicketBookingApp1Application.class, args);
		}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Ticket ticket=new Ticket();
		//ticket.setTicketId(1);
		ticket.setBookingDate(new java.util.Date());
		ticket.setSourceStation("Pune");
		ticket.setDestinationStation("Bangalore");
		ticket.setPassengerName("Rajeev");
		
		ticketBookingService.createTicket(ticket);
	}

}
