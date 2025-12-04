package com.telusko.TouristMangApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.telusko.TouristMangApp.dao.ITicketRepo;
import com.telusko.TouristMangApp.model.Passenger;

@Service
//@Scope("prototype")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TicketBookingService implements ITicketBookingService 
{
	@Autowired
	private ITicketRepo repo;
	
	public TicketBookingService()
	{
		System.out.println("TicketBookingService bean created");
	}

	@Override
	public Passenger registerPassenger(Passenger passenger) 
	{
		
		return repo.save(passenger);
	}

	@Override
	public Passenger fetchPassengerDetails(Integer id) 
	{
		System.out.println("HashCode of repo internal bean "+repo.hashCode());
		Optional<Passenger> optional = repo.findById(id);
		
		return optional.get();
	}

}
