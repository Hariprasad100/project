package com.jsp.EventManagmentCONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.EventManagment.Service.EventCsvService;

@RestController
@RequestMapping("/api") // Base path for controller
public class CsvController 
{
	private final EventCsvService ecv;
	
	@Autowired
    public CsvController(EventCsvService ecv) {
        this.ecv = ecv;
    }
	
	 @PostMapping("ingest")
	 public String ingestCsv(@RequestParam(required = false) String csvFilePath)
	 {
		ecv.ingestCsv(csvFilePath);
		return "CSV Data ingested successfully.."; 
	 }
}
