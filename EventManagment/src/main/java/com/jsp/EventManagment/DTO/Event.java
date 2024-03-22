package com.jsp.EventManagment.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Event 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String event_name;
	private String city_name;
	private LocalDate date;
	private LocalTime time;
	private double latitude;
	private double longitude;
}
