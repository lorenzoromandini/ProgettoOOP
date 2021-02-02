/**
 * 
 */
package eu.univpm.TicketmasterEurope.service;

import org.json.JSONArray;
import org.json.JSONObject;

import eu.univpm.TicketmasterEurope.model.*;

/** Questa classe permette di convertire un oggetto Location in un JSONObject
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class JSON_Converter {

	EventsArray eventsArray = new EventsArray();
	
	/**
	 * Restituisce il JSONObject corrispondente all'oggetto EventsArray fornito in ingresso
	 * 
	 * @param eventsarray
	 * @return JSONObject obj
	 */
	public JSONObject JSON_converter(EventsArray eventsArray) {
		
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		
	    for(int i = 0; i < (eventsArray.getVector()).size(); i++) {
	    
		    obj.put("placement", (eventsArray.getVector()).get(i).getLocation().getPlace().getPlacement());
		    obj.put("address", (eventsArray.getVector()).get(i).getLocation().getPlace().getAddress());
		    obj.put("city", (eventsArray.getVector()).get(i).getLocation().getPlace().getCity());
		    obj.put("country", (eventsArray.getVector()).get(i).getLocation().getCountry().getCountry());
		    obj.put("countryCode", (eventsArray.getVector()).get(i).getLocation().getCountry().getCountryCode());
		    obj.put("marketId",  (eventsArray.getVector()).get(i).getLocation().getMarket().getMarketId());
		    obj.put("marketName", (eventsArray.getVector()).get(i).getLocation().getMarket().getMarketName());
			obj.put("data", (eventsArray.getVector()).get(i).getDate().getData());
			obj.put("orario", (eventsArray.getVector()).get(i).getDate().getOrario());
			obj.put("segmentName", (eventsArray.getVector()).get(i).getGenre().getSegmentName());
			obj.put("genreName", (eventsArray.getVector()).get(i).getGenre().getGenreName());
			obj.put("subGenreName", (eventsArray.getVector()).get(i).getGenre().getSubGenreName());
			obj.put("id", (eventsArray.getVector()).get(i).getId());
			obj.put("name", (eventsArray.getVector()).get(i).getName());
			obj.put("url", (eventsArray.getVector()).get(i).getUrl());
			obj.put("info", (eventsArray.getVector()).get(i).getInfo());
			obj.put("currency", (eventsArray.getVector()).get(i).getPrices().getCurrency());
			obj.put("minPrice", (eventsArray.getVector()).get(i).getPrices().getMinPrice());
			obj.put("maxPrice", (eventsArray.getVector()).get(i).getPrices().getMaxPrice());
			array.put(eventsArray);
		}
	    
		obj.put("Events", array);
		return obj;
		
	}
	
	
}
