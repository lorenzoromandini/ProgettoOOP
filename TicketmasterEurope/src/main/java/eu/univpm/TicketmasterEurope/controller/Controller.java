/**
 * 
 */
package eu.univpm.TicketmasterEurope.controller;

import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.univpm.TicketmasterEurope.service.JSON_Converter;
import eu.univpm.TicketmasterEurope.service.*;
import eu.univpm.TicketmasterEurope.exception.*;
import eu.univpm.TicketmasterEurope.filters.Filter;
import eu.univpm.TicketmasterEurope.model.*;
import eu.univpm.TicketmasterEurope.stats.*;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */

@RestController

public class Controller {
	
	@Autowired
	Service service;
	
	Stats stats;
	
	
	@GetMapping(value = "/countryEvents") 
	public ResponseEntity<Object> getCountryEvent(@RequestParam String countryCode) {
		
		EventsArray eventsArray = service.getCountryEventsSelectedfromApi(countryCode);
		
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(eventsArray);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
    }
	
	
	@GetMapping(value = "/marketEvents") 
	public ResponseEntity<Object> getMarketEvent(@RequestParam String marketId) {
		
        EventsArray eventsArray = service.getMarketEventsSelectedfromApi(marketId);		
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(eventsArray);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
    }
	
	
	@GetMapping(value = "/sourceCountryEvents") 
	public ResponseEntity<Object> getSourceEvent(@RequestParam String source, String countryCode) {
		
        EventsArray eventsArray = service.getSourceEventsSelectedfromApi(source, countryCode);		
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(eventsArray);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
    }
	
	
	@PostMapping("/filters")
	public ResponseEntity<Object> filters(@RequestBody String body) throws WrongComparisonException, WrongPeriodException, WrongValueException, WrongParameterException {
		
		JSONObject object = new JSONObject(body);
        JSONArray array = new JSONArray();
        
        String comparison = object.getString("comparison");
        
        array = object.getJSONArray("elements");
        
        Vector<String> elements = new Vector<String>(array.length());
        
        for(int i = 0; i < array.length(); i++) {
        	
            JSONObject obj = new JSONObject();
            obj = array.getJSONObject(i);
            elements.add(obj.getString("name"));
        }
        
        String param = object.getString("param");
        String value = object.getString("value"); 
        int period = object.getInt("period");
		
        Filter filter = new Filter(comparison, elements, param, value, period);
		
		try {
        	return new ResponseEntity<>(filter.getFilter().toString(),HttpStatus.OK);
        }
		catch(WrongComparisonException e) {
        	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
		catch(WrongPeriodException e) {
	        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	        }
		catch(WrongValueException e) {
        	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
		catch(WrongParameterException e) {
        	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
		
		
	}
	
	
	
		
}
	
