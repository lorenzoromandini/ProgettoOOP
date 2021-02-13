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
 *  un genre in base al paese e in funzione del periodo su cui si vuole effettuare tale ricerca
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class GenreComparison implements FilterMonthInterface {
	
	Stats stats = new StatsManagement();
	
	VoidGetException Exception = new VoidGetException();
	

	public JSONArray Months(Vector<String> genres, String country, int period) throws WrongValueException, WrongCountryException {
		
		Exception.genreVectorException(genres);
		Exception.countryStringException(country);
		
		JSONArray genreEvents = new JSONArray();
		
		Iterator<String> it = genres.iterator();
		
		int i = 0;
		
		String maxGenre = null;
		String minGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getGenreEvents(country, it.next(), period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("genre: ", genres.get(i));
			couple.put("totalEvents: ", totalElements);
			genreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minGenre = genres.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxGenre = genres.get(i);
			}

			i++;
				
			}
		
		JSONObject maxGenreEvents = new JSONObject();
		maxGenreEvents.put("Genre with most events: ", maxGenre);
		maxGenreEvents.put("totalEvents: ", maxEvent);
		JSONObject minGenreEvents = new JSONObject();
		minGenreEvents.put("Genre with least events: ", minGenre);
		minGenreEvents.put("totalEvents: ", minEvent);
		
		genreEvents.put(maxGenreEvents);
		genreEvents.put(minGenreEvents);
		
		return genreEvents;

    }
	

	
}