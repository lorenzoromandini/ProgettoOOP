/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import eu.univpm.TicketmasterEurope.exception.VoidGetException;
import eu.univpm.TicketmasterEurope.exception.WrongCountryException;
import eu.univpm.TicketmasterEurope.exception.WrongValueException;
import eu.univpm.TicketmasterEurope.stats.Stats;
import eu.univpm.TicketmasterEurope.stats.StatsManagement;

/** Questa classe implementa FilterMonthInterface e contiene i metodi per il filtraggio degli eventi di 
 *  un subgenre in base al paese e in funzione del periodo su cui si vuole effettuare tale ricerca
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class SubGenreComparison implements FilterMonthInterface {
	
	Stats stats = new StatsManagement();
	
	VoidGetException Exception = new VoidGetException();
	

	public JSONArray Months(Vector<String> subGenres, String country, int period) throws WrongValueException, WrongCountryException {
		
		Exception.subgenreVectorException(subGenres);
		Exception.countryStringException(country);
		
		JSONArray subGenreEvents = new JSONArray();
		
		Iterator<String> it = subGenres.iterator();
		
		int i = 0;
		
		String maxSubGenre = null;
		String minSubGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(country, it.next(), period);
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