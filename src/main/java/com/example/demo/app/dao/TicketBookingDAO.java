package com.example.demo.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.app.entities.Ticket;


public interface TicketBookingDAO extends CrudRepository<Ticket,Integer> {

}
