package com.telusko.TouristMangApp.service;

import com.telusko.TouristMangApp.model.Passenger;

public interface ITicketBookingService 
{
	public Passenger registerPassenger(Passenger passenger);
	public Passenger fetchPassengerDetails(Integer id);

}
