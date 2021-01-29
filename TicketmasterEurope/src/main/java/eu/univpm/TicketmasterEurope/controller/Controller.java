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
import eu.univpm.TicketmasterEurope.model.*;

import eu.univpm.TicketmasterEurope.service.Service;


/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */

@RestController

public class Controller {
	
	@Autowired
	Service service;
	
	
	
	@GetMapping(value = "/events") 
	public ResponseEntity<Object> getCountryEvents(@RequestParam String country) {
		
		Location location = service.getCountryEventsfromApi(country);
		
		JSONObject obj = new JSONObject();
		ToJSON tojson = new ToJSON();
		
		obj = tojson.toJson(country);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
    }
		
	
	
		
}
	
	

	

}
