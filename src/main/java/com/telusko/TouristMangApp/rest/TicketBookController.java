package com.telusko.TouristMangApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.TouristMangApp.model.Passenger;
import com.telusko.TouristMangApp.model.Ticket;
import com.telusko.TouristMangApp.service.ITicketBookingService;
import com.telusko.TouristMangApp.service.TicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/book-ticket")
@Tag(name="TicketBookingAPIS", description="APIS to book ticket by passing passenegr info ")
@Scope("request")
//@Scope("session")
public class TicketBookController 
{
	@Autowired
	private ITicketBookingService service;
	
	@Autowired
	private TicketService ser;
	
	public TicketBookController()
	{
		System.out.println("TicketBookController bean created");
	}
	
	@PostMapping("/getTicketNumber")
	@Operation(summary="POST operation", description="API will accept json type of passeneger info and will return ticket number")
	public ResponseEntity<Ticket> registerPassenger(@RequestBody Passenger passenger)
	{
		//System.out.println("hashcode of controller "+ );
		Passenger pass=service.registerPassenger(passenger);
		Ticket ticket=new Ticket();
		ticket.setTicketNumber(pass.getPid());
//		Integer id=pass.getPid();
//		String ticket="ticket- "+id;
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
		
	}
	
	@GetMapping("/getTicket/{ticketNumber}")
	@Operation(summary="GET operation", description="API will accept ticket number info and will return detailed ticket object")
	public ResponseEntity<Ticket> getFullTicketInfo(@PathVariable("ticketNumber") Integer ticketNumber)
	{
		Passenger passenger = service.fetchPassengerDetails(ticketNumber);
		ser.ticketService();
		System.out.println("HashCode of repo dev created service  bean "+service.hashCode());
		Ticket ticket=new Ticket();
		ticket.setTicketNumber(ticketNumber);
		ticket.setName(passenger.getName());
		ticket.setDeparture(passenger.getDeparture());
		ticket.setArrival(passenger.getArrival());
		ticket.setDateOfJourney(passenger.getDateOfJourney());
		ticket.setStatus("confirmed");
		ticket.setTicketCost(444.45);
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);

		
	}

}
