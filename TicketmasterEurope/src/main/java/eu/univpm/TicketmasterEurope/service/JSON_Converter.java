/**
 * 
 */
package eu.univpm.TicketmasterEurope.service;

import org.json.JSONArray;
import org.json.JSONObject;

import eu.univpm.TicketmasterEurope.model.*;

/**
 * @author loren
 *
 */

public class JSON_Converter {

	Location location = new Location();
	
	public JSONObject JSON_converter(Location location) {
		
		JSONObject obj = new JSONObject();
		
		obj.put("placement", location.getPlacement());
		obj.put("address", location.getAddress());
		obj.put("city", location.getCity());
		obj.put("country", location.getCountry());
		obj.put("countrycode", location.getCountrycode());
		
		JSONArray array = new JSONArray();

		for(int i = 0; i < (location.getVector()).size(); i++) {
			JSONObject event = new JSONObject();
			event.put("data", (city.getVector()).get(i).getData());
			event.put("data", (city.getVector()).get(i).getData());
			event.put("data", (city.getVector()).get(i).getData());
			event.put("data", (city.getVector()).get(i).getData());
			event.put("data", (city.getVector()).get(i).getData());
			event.put("data", (city.getVector()).get(i).getData());
			event.put("data", (city.getVector()).get(i).getData());
			event.put("data", (city.getVector()).get(i).getData());
			event.put("data", (city.getVector()).get(i).getData());
			event.put("data", (city.getVector()).get(i).getData());
			event.put("data", (city.getVector()).get(i).getData());
			event.put("data", (city.getVector()).get(i).getData());

			
		}
		
		
		
		
	}
	
	
	
}
