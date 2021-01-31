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
import eu.univpm.TicketmasterEurope.service.Service;
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
		
		Location location = service.getCountryEventsSelectedfromApi(countryCode);
		
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(location);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
    }
	
	

		
}
	
