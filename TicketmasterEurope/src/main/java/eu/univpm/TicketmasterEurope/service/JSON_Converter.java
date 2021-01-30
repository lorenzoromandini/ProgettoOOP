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
		obj.put("countryCode", location.getCountrycode());
		obj.put("marketId", location.getMarketId());
		obj.put("marketName", location.getMarketName());
		
		JSONArray array = new JSONArray();

		for(int i = 0; i < (location.getEvento()).size(); i++) {
			JSONObject event = new JSONObject();
			event.put("data", (location.getEvento()).get(i).getDate().getData());
			event.put("orario", (location.getEvento()).get(i).getDate().getOrario());
			event.put("segmentName", (location.getEvento()).get(i).getGenre().getSegmentName());
			event.put("genreName", (location.getEvento()).get(i).getGenre().getGenreName());
			event.put("subGenreName", (location.getEvento()).get(i).getGenre().getSubGenreName());
			event.put("id", (location.getEvento()).get(i).getId());
			event.put("name", (location.getEvento()).get(i).getName());
			event.put("info", (location.getEvento()).get(i).getInfo());
			event.put("currency", (location.getEvento()).get(i).getFeatures().getCurrency());
			event.put("minPrice", (location.getEvento()).get(i).getFeatures().getMinPrice());
			event.put("maxPrice", (location.getEvento()).get(i).getFeatures().getMaxPrice());
			event.put("source", (location.getEvento()).get(i).getFeatures().getSource());
			array.put(event);
		}
		
		obj.put("Event", array);
		return obj;
	}
	
	
	
}
