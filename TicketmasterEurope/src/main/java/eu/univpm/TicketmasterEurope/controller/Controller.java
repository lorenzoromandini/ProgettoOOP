/**
 * 
 */
package eu.univpm.TicketmasterEurope.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.univpm.TicketmasterEurope.service.JSON_Converter;
import eu.univpm.TicketmasterEurope.service.*;
import eu.univpm.TicketmasterEurope.model.*;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */

@RestController

public class Controller {
	
	@Autowired
	Service service;
	
	
	@GetMapping(value = "/countryevents") 
	public ResponseEntity<Object> getCountryEvents(@RequestParam String countryCode) {
		
		EventsArray eventsArray = service.getCountryEventsSelectedfromApi(countryCode);
		
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(eventsArray);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
    }
	
	
	@GetMapping(value = "/marketevents") 
	public ResponseEntity<Object> getMarketEvents(@RequestParam String marketId) {
		
		EventsArray eventsArray = service.getMarketEventsSelectedfromApi(marketId);
		
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(eventsArray);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
		

    }
		
	
		
}
	
