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

	//EventsArray eventsArray = new EventsArray();
	
	/**
	 * Restituisce il JSONObject corrispondente all'oggetto EventsArray fornito in ingresso
	 * 
	 * @param eventsarray
	 * @return JSONObject obj
	 */
	public JSONObject JSON_converter(EventsArray eventsArray) {
		
		
		JSONArray array = new JSONArray();
		JSONObject events = new JSONObject();
		
	    for(int i = 0; i < (eventsArray.getVector()).size(); i++) {
	    	
	    	JSONObject obj = new JSONObject();
	    
	    	if ((eventsArray.getVector()).get(i).getLocation().getPlace().getPlacement() != null) 
		    obj.put("placement", (eventsArray.getVector()).get(i).getLocation().getPlace().getPlacement());
	    	if ((eventsArray.getVector()).get(i).getLocation().getPlace().getAddress() != null)
		    obj.put("address", (eventsArray.getVector()).get(i).getLocation().getPlace().getAddress());
	    	if ((eventsArray.getVector()).get(i).getLocation().getPlace().getCity() != null)
		    obj.put("city", (eventsArray.getVector()).get(i).getLocation().getPlace().getCity());
	    	if ((eventsArray.getVector()).get(i).getLocation().getCountry().getCountry() != null)
		    obj.put("country", (eventsArray.getVector()).get(i).getLocation().getCountry().getCountry());
	    	if ((eventsArray.getVector()).get(i).getLocation().getCountry().getCountryCode() != null)
		    obj.put("countryCode", (eventsArray.getVector()).get(i).getLocation().getCountry().getCountryCode());
	    	if ((eventsArray.getVector()).get(i).getLocation().getMarket().getMarketId() != null)
		    obj.put("marketId",  (eventsArray.getVector()).get(i).getLocation().getMarket().getMarketId());
	    	if ((eventsArray.getVector()).get(i).getLocation().getMarket().getMarketName() != null)
		    obj.put("marketName", (eventsArray.getVector()).get(i).getLocation().getMarket().getMarketName());
	    	if ((eventsArray.getVector()).get(i).getDate().getData() != null)
			obj.put("date", (eventsArray.getVector()).get(i).getDate().getData());
	    	if ((eventsArray.getVector()).get(i).getDate().getOrario() != null)
			obj.put("time", (eventsArray.getVector()).get(i).getDate().getOrario());
	    	if ((eventsArray.getVector()).get(i).getGenre().getSegmentName() != null)
			obj.put("segment", (eventsArray.getVector()).get(i).getGenre().getSegmentName());
	    	if ((eventsArray.getVector()).get(i).getGenre().getGenreName() != null)
			obj.put("genre", (eventsArray.getVector()).get(i).getGenre().getGenreName());
	    	if ((eventsArray.getVector()).get(i).getGenre().getSubGenreName() != null)
			obj.put("subGenre", (eventsArray.getVector()).get(i).getGenre().getSubGenreName());
	    	if ((eventsArray.getVector()).get(i).getId() != null)
			obj.put("id", (eventsArray.getVector()).get(i).getId());
	    	if ((eventsArray.getVector()).get(i).getName() != null)
			obj.put("eventName", (eventsArray.getVector()).get(i).getName());
	    	if ((eventsArray.getVector()).get(i).getUrl() != null)
			obj.put("url", (eventsArray.getVector()).get(i).getUrl());
	    	if ((eventsArray.getVector()).get(i).getInfo() != null)
			obj.put("info", (eventsArray.getVector()).get(i).getInfo());
	    	if ((eventsArray.getVector()).get(i).getPrices().getCurrency() != null)
			obj.put("currency", (eventsArray.getVector()).get(i).getPrices().getCurrency());
	    	if ((eventsArray.getVector()).get(i).getPrices().getMinPrice() != 0)
			obj.put("minPrice", (eventsArray.getVector()).get(i).getPrices().getMinPrice());
	        if ((eventsArray.getVector()).get(i).getPrices().getMaxPrice() != 0)
			obj.put("maxPrice", (eventsArray.getVector()).get(i).getPrices().getMaxPrice());
			array.put(obj);
		}
	    
		events.put("Events", array);
		
		return events;
		
	}
	
	
}
