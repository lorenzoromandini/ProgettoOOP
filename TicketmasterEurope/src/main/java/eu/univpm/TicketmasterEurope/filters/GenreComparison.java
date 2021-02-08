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

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class GenreComparison implements FilterInterface {
	
	Stats stats;
	

	public JSONArray OneMonth(Vector<String> genres, String country) throws WrongValueException {
		
		JSONArray genreEvents = new JSONArray();
		
		Vector<JSONObject> genreVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = genres.iterator();
		
		int i = 0;
		
		String maxGenre = null;
		String minGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getGenreEvents(country, it.next(), 1);
			genreVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", genres.get(i));
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
	

	public JSONArray ThreeMonths(Vector<String> genres, String country) throws WrongValueException {
		
        JSONArray genreEvents = new JSONArray();
		
		Vector<JSONObject> genreVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = genres.iterator();
		
		int i = 0;
		
		String maxGenre = null;
		String minGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getGenreEvents(country, it.next(), 3);
			genreVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", genres.get(i));
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
	

	public JSONArray SixMonths(Vector<String> genres, String country) throws WrongValueException {
		
        JSONArray genreEvents = new JSONArray();
		
		Vector<JSONObject> genreVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = genres.iterator();
		
		int i = 0;
		
		String maxGenre = null;
		String minGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getGenreEvents(country, it.next(), 6);
			genreVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", genres.get(i));
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
	

	public JSONArray TwelveMonths(Vector<String> genres, String country) throws WrongValueException {
		
        JSONArray genreEvents = new JSONArray();
		
		Vector<JSONObject> genreVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = genres.iterator();
		
		int i = 0;
		
		String maxGenre = null;
		String minGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getGenreEvents(country, it.next(), 12);
			genreVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", genres.get(i));
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

