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
	    	
	    	try {
	    		
	    	try {
			obj.put("source", (eventsArray.getVector()).get(i).getDealer().getSource());
			} catch(Exception e) {
				e.printStackTrace();
			} 
	    
	    	try {
		    obj.put("placement", (eventsArray.getVector()).get(i).getLocation().getPlace().getPlacement());
	    	} catch(Exception e) {
				e.printStackTrace();
			}
		    
		    try {
		    obj.put("address", (eventsArray.getVector()).get(i).getLocation().getPlace().getAddress());
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
		    try {
		    obj.put("city", (eventsArray.getVector()).get(i).getLocation().getPlace().getCity());
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
		    try {
		    obj.put("country", (eventsArray.getVector()).get(i).getLocation().getCountry().getCountry());
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
		    try {
		    obj.put("countryCode", (eventsArray.getVector()).get(i).getLocation().getCountry().getCountryCode());
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
		    try {
		    obj.put("marketId",  (eventsArray.getVector()).get(i).getLocation().getMarket().getMarketId());
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
		    try {
		    obj.put("marketName", (eventsArray.getVector()).get(i).getLocation().getMarket().getMarketName());
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
		    try {
			obj.put("startDate", (eventsArray.getVector()).get(i).getDate().getDataInizio());
		    } catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
			obj.put("startTime", (eventsArray.getVector()).get(i).getDate().getOrarioInizio());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
			obj.put("segment", (eventsArray.getVector()).get(i).getGenre().getSegmentName());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
			obj.put("genre", (eventsArray.getVector()).get(i).getGenre().getGenreName());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
			obj.put("subGenre", (eventsArray.getVector()).get(i).getGenre().getSubGenreName());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
			obj.put("id", (eventsArray.getVector()).get(i).getId());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
			obj.put("eventName", (eventsArray.getVector()).get(i).getName());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
			obj.put("url", (eventsArray.getVector()).get(i).getUrl());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
			obj.put("info", (eventsArray.getVector()).get(i).getInfo());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
			obj.put("currency", (eventsArray.getVector()).get(i).getPrices().getCurrency());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
			obj.put("minPrice", (eventsArray.getVector()).get(i).getPrices().getMinPrice());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
			obj.put("maxPrice", (eventsArray.getVector()).get(i).getPrices().getMaxPrice());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
	    	 } catch(Exception e) {
					e.printStackTrace();
				}
	    	
			array.put(obj);
		}
	    
		events.put("Events", array);
		events.put("totalEvents", eventsArray.getTotalEvents());
		events.put("showedEvents", eventsArray.getShowedEvents());
	
		return events;
		
	}
	
	
}
