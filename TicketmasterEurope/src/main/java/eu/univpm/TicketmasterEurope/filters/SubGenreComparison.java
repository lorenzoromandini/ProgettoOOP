/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import eu.univpm.TicketmasterEurope.exception.WrongValueException;
import eu.univpm.TicketmasterEurope.stats.Stats;
import eu.univpm.TicketmasterEurope.stats.StatsManagement;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class SubGenreComparison implements FilterInterface {
	
	Stats stats = new StatsManagement();
	

	public JSONArray OneMonth(Vector<String> subGenres, String country) throws WrongValueException {
		
		JSONArray subGenreEvents = new JSONArray();
		
		Iterator<String> it = subGenres.iterator();
		
		int i = 0;
		
		String maxSubGenre = null;
		String minSubGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(country, it.next(), 1);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("subGenre: ", subGenres.get(i));
			couple.put("totalEvents: ", totalElements);
			subGenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minSubGenre = subGenres.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSubGenre = subGenres.get(i);
			}

			i++;
				
			}
		
		JSONObject maxSubGenreEvents = new JSONObject();
		maxSubGenreEvents.put("SubGenre with most events: ", maxSubGenre);
		maxSubGenreEvents.put("totalEvents: ", maxEvent);
		JSONObject minSubGenreEvents = new JSONObject();
		minSubGenreEvents.put("SubGenre with least events: ", minSubGenre);
		minSubGenreEvents.put("totalEvents: ", minEvent);
		
		subGenreEvents.put(maxSubGenreEvents);
		subGenreEvents.put(minSubGenreEvents);
		
		return subGenreEvents;

    }
	

	public JSONArray ThreeMonths(Vector<String> subGenres, String country) throws WrongValueException {
		
        JSONArray subGenreEvents = new JSONArray();
		
		Iterator<String> it = subGenres.iterator();
		
		int i = 0;
		
		String maxSubGenre = null;
		String minSubGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(country, it.next(), 3);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("subGenre: ", subGenres.get(i));
			couple.put("totalEvents: ", totalElements);
			subGenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minSubGenre = subGenres.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSubGenre = subGenres.get(i);
			}

			i++;
				
			}
		
		JSONObject maxSubGenreEvents = new JSONObject();
		maxSubGenreEvents.put("SubGenre with most events: ", maxSubGenre);
		maxSubGenreEvents.put("totalEvents: ", maxEvent);
		JSONObject minSubGenreEvents = new JSONObject();
		minSubGenreEvents.put("SubGenre with least events: ", minSubGenre);
		minSubGenreEvents.put("totalEvents: ", minEvent);
		
		subGenreEvents.put(maxSubGenreEvents);
		subGenreEvents.put(minSubGenreEvents);
		
		return subGenreEvents;
	
	}
	

	public JSONArray SixMonths(Vector<String> subGenres, String country) throws WrongValueException {
		
        JSONArray subGenreEvents = new JSONArray();
		
		Iterator<String> it = subGenres.iterator();
		
		int i = 0;
		
		String maxSubGenre = null;
		String minSubGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(country, it.next(), 6);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("subGenre: ", subGenres.get(i));
			couple.put("totalEvents: ", totalElements);
			subGenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minSubGenre = subGenres.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSubGenre = subGenres.get(i);
			}

			i++;
				
			}
		
		JSONObject maxSubGenreEvents = new JSONObject();
		maxSubGenreEvents.put("SubGenre with most events: ", maxSubGenre);
		maxSubGenreEvents.put("totalEvents: ", maxEvent);
		JSONObject minSubGenreEvents = new JSONObject();
		minSubGenreEvents.put("SubGenre with least events: ", minSubGenre);
		minSubGenreEvents.put("totalEvents: ", minEvent);
		
		subGenreEvents.put(maxSubGenreEvents);
		subGenreEvents.put(minSubGenreEvents);
		
		return subGenreEvents;
		
	}
	

	public JSONArray TwelveMonths(Vector<String> subGenres, String country) throws WrongValueException {
		
        JSONArray subGenreEvents = new JSONArray();
		
		Iterator<String> it = subGenres.iterator();
		
		int i = 0;
		
		String maxSubGenre = null;
		String minSubGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(country, it.next(), 12);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("subGenre: ", subGenres.get(i));
			couple.put("totalEvents: ", totalElements);
			subGenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minSubGenre = subGenres.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSubGenre = subGenres.get(i);
			}

			i++;
				
			}
		
		JSONObject maxSubGenreEvents = new JSONObject();
		maxSubGenreEvents.put("SubGenre with most events: ", maxSubGenre);
		maxSubGenreEvents.put("totalEvents: ", maxEvent);
		JSONObject minSubGenreEvents = new JSONObject();
		minSubGenreEvents.put("SubGenre with least events: ", minSubGenre);
		minSubGenreEvents.put("totalEvents: ", minEvent);
		
		subGenreEvents.put(maxSubGenreEvents);
		subGenreEvents.put(minSubGenreEvents);
		
		return subGenreEvents;
		
	}
 
	
}