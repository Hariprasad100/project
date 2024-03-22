package com.jsp.EventManagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.EventManagment.DTO.Event;
@Repository
public interface EventRepository extends JpaRepository<Event, Long>
{
	
}
