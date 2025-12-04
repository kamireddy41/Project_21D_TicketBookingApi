package com.telusko.TouristMangApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.telusko.TouristMangApp.dao.ITicketRepo;

@Service
//@Scope("prototype")
public class TicketService 
{
	
	//@Autowired
	private ITicketRepo repo;
	
	@Autowired
	private ITicketBookingService service;
	
	public TicketService()
	{
		System.out.println("TicketService bean created");
	}
	
	public void ticketService()
	{
		//System.out.println("HashCode of repo internal bean "+repo.hashCode());
		
		System.out.println("HashCode of repo dev created service  bean "+service.hashCode());
	}

}
