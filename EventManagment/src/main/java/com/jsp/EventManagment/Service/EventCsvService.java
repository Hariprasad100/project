package com.jsp.EventManagment.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.jsp.EventManagment.DTO.Event;
import com.jsp.EventManagment.repository.EventRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class EventCsvService 
{
	private EventRepository repository;
	
	@Value("${csv.defaultFilePath}")
	private String defaultCsvFilePath;
	
	@Autowired
	public EventCsvService(EventRepository repository)
	{
		this.repository = repository;
	}
	

	public void ingestCsv(String csvFilePath) {
        if (csvFilePath == null) {
            csvFilePath = defaultCsvFilePath; // Use default file path if not provided
        }

        try(CSVReader reader = new CSVReader(new FileReader(csvFilePath)))
        {
        	String[] nextLine;
        	while((nextLine = reader.readNext()) != null)
        	{
        		Event event = new Event();
                event.setEvent_name(nextLine[0]);
                event.setCity_name(nextLine[1]);
                event.setDate(LocalDate.parse(nextLine[2]));
                event.setTime(LocalTime.parse(nextLine[3]));
                event.setLatitude(Double.parseDouble(nextLine[4]));
                event.setLongitude(Double.parseDouble(nextLine[5]));
                repository.save(event);
        	}
        }
        catch(IOException | CsvValidationException e)
        {
        	e.printStackTrace();
        }
        
	}
}

