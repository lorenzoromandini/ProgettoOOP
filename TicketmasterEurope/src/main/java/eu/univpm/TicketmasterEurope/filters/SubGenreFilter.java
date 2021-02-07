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
public class SubGenreFilter implements FilterInterface {
	
	Stats stats;
	

	public JSONArray OneMonth(Vector<String> countries, String subGenre) throws WrongValueException {
		
		JSONArray subGenreEvents = new JSONArray();
		
		Vector<JSONObject> countryVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		Vector<JSONObject> country_totalEvents = new Vector<JSONObject>();
		
		Iterator<String> it = countries.iterator();
		
		int i = 0;
		
		String maxCountry = null;
		String minCountry = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(it.next(), subGenre, 1);
			countryVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", countries.get(i));
			couple.put("totalEvents: ", totalElements);
			country_totalEvents.add(couple);
			subGenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minCountry = countries.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxCountry = countries.get(i);
			}

			i++;
				
			}
		
		JSONObject maxCountryEvents = new JSONObject();
		maxCountryEvents.put("Country with most events: ", maxCountry);
		maxCountryEvents.put("totalEvents: ", maxEvent);
		JSONObject minCountryEvents = new JSONObject();
		minCountryEvents.put("Country with least events: ", minCountry);
		minCountryEvents.put("totalEvents: ", minEvent);
		
		subGenreEvents.put(maxCountryEvents);
		subGenreEvents.put(minCountryEvents);
		
		return subGenreEvents;

    }

	public JSONArray ThreeMonths(Vector<String> countries, String subGenre) throws WrongValueException {
		
		JSONArray subGenreEvents = new JSONArray();
		
		Vector<JSONObject> countryVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		Vector<JSONObject> country_totalEvents = new Vector<JSONObject>();
		
		Iterator<String> it = countries.iterator();
		
		int i = 0;
		
		String maxCountry = null;
		String minCountry = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(it.next(), subGenre, 3);
			countryVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", countries.get(i));
			couple.put("totalEvents: ", totalElements);
			country_totalEvents.add(couple);
			subGenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minCountry = countries.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxCountry = countries.get(i);
			}

			i++;
				
			}
		
		JSONObject maxCountryEvents = new JSONObject();
		maxCountryEvents.put("Country with most events: ", maxCountry);
		maxCountryEvents.put("totalEvents: ", maxEvent);
		JSONObject minCountryEvents = new JSONObject();
		minCountryEvents.put("Country with least events: ", minCountry);
		minCountryEvents.put("totalEvents: ", minEvent);
		
		subGenreEvents.put(maxCountryEvents);
		subGenreEvents.put(minCountryEvents);
		
		return subGenreEvents;
		
	}

	public JSONArray SixMonths(Vector<String> countries, String subGenre) throws WrongValueException {
		
        JSONArray subGenreEvents = new JSONArray();
		
		Vector<JSONObject> countryVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		Vector<JSONObject> country_totalEvents = new Vector<JSONObject>();
		
		Iterator<String> it = countries.iterator();
		
		int i = 0;
		
		String maxCountry = null;
		String minCountry = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(it.next(), subGenre, 6);
			countryVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", countries.get(i));
			couple.put("totalEvents: ", totalElements);
			country_totalEvents.add(couple);
			subGenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minCountry = countries.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxCountry = countries.get(i);
			}

			i++;
				
			}
		
		JSONObject maxCountryEvents = new JSONObject();
		maxCountryEvents.put("Country with most events: ", maxCountry);
		maxCountryEvents.put("totalEvents: ", maxEvent);
		JSONObject minCountryEvents = new JSONObject();
		minCountryEvents.put("Country with least events: ", minCountry);
		minCountryEvents.put("totalEvents: ", minEvent);
		
		subGenreEvents.put(maxCountryEvents);
		subGenreEvents.put(minCountryEvents);
		
		return subGenreEvents;
		
	}

	public JSONArray TwelveMonths(Vector<String> countries, String subGenre) throws WrongValueException {
		
        JSONArray subGenreEvents = new JSONArray();
		
		Vector<JSONObject> countryVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		Vector<JSONObject> country_totalEvents = new Vector<JSONObject>();
		
		Iterator<String> it = countries.iterator();
		
		int i = 0;
		
		String maxCountry = null;
		String minCountry = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(it.next(), subGenre, 12);
			countryVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", countries.get(i));
			couple.put("totalEvents: ", totalElements);
			country_totalEvents.add(couple);
			subGenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minCountry = countries.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxCountry = countries.get(i);
			}

			i++;
				
			}
		
		JSONObject maxCountryEvents = new JSONObject();
		maxCountryEvents.put("Country with most events: ", maxCountry);
		maxCountryEvents.put("totalEvents: ", maxEvent);
		JSONObject minCountryEvents = new JSONObject();
		minCountryEvents.put("Country with least events: ", minCountry);
		minCountryEvents.put("totalEvents: ", minEvent);
		
		subGenreEvents.put(maxCountryEvents);
		subGenreEvents.put(minCountryEvents);
		
		return subGenreEvents;

	}
 
	
}

