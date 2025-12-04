package com.telusko.TouristMangApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.TouristMangApp.model.Passenger;

public interface ITicketRepo extends JpaRepository<Passenger, Integer>
{

}
